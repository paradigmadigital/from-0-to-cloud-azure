# Configure the Azure provider
terraform {
  required_providers {
    azurerm = {
      source  = "hashicorp/azurerm"
      version = "~> 2.65"
    }
  }
  backend "azurerm" {
    resource_group_name  = "rvillar-rgp-common"
    storage_account_name = "rvillarcommon"
    container_name       = "tfstate"
    key                  = "zero2azure.terraform.tfstate"
  }

  required_version = ">= 0.14.9"
}

provider "azurerm" {
  features {}
}

resource "azurerm_resource_group" "rg" {
  name     = var.resource_group_name
  location = var.location
  tags     = var.tags
}

resource "azurerm_container_registry" "acr" {
  name                = var.acr_configuration.name
  resource_group_name = azurerm_resource_group.rg.name
  location            = azurerm_resource_group.rg.location
  sku                 = var.acr_configuration.sku
  admin_enabled       = var.acr_configuration.admin_enabled
  tags                = var.tags
}

resource "azurerm_kubernetes_cluster" "aks" {
  name                = var.aks_configuration.name
  location            = azurerm_resource_group.rg.location
  resource_group_name = azurerm_resource_group.rg.name
  dns_prefix          = var.aks_configuration.dns_prefix
  kubernetes_version  = var.aks_configuration.kubernetes_version

  default_node_pool {
    name       = var.aks_configuration.default_node_pool.name
    node_count = var.aks_configuration.default_node_pool.node_count
    vm_size    = var.aks_configuration.default_node_pool.vm_size
  }

  identity {
    type = var.aks_configuration.identity.type
  }

  addon_profile {

    http_application_routing {
      enabled = var.aks_configuration.http_application_routing.enabled
    }

    oms_agent {
      enabled = var.aks_configuration.oms_agent.enabled
    }

  }

  tags = var.tags
}

resource "azurerm_role_assignment" "acrpull_role" {
  scope                            = azurerm_container_registry.acr.id
  role_definition_name             = "AcrPull"
  principal_id                     = azurerm_kubernetes_cluster.aks.kubelet_identity[0].object_id
  skip_service_principal_aad_check = true
}

output "kubeconfig" {
  value     = azurerm_kubernetes_cluster.aks.kube_config_raw
  sensitive = true
}
