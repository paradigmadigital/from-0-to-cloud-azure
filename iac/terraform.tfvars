resource_group_name = "rgp-zero2azure"

location = "westeurope"

acr_configuration = {
  name          = "acrzero2azure"
  sku           = "Basic"
  admin_enabled = false
}

aks_configuration = {
  name               = "aks-zero2azure"
  dns_prefix         = "aks-zero2azure"
  kubernetes_version = "1.21.1"

  default_node_pool = {
    name       = "default"
    node_count = 1
    vm_size    = "Standard_DS2_v2"
  }
  identity = {
    type = "SystemAssigned"
  }
  http_application_routing = {
    enabled = true
  }
  oms_agent = {
    enabled = false
  }
}

tags = {
  author  = "rvillar"
  project = "zero2azure"
}