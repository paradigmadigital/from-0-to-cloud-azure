variable "resource_group_name" {}

variable "location" {}

variable "aks_configuration" {
  type = object({
    name               = string
    dns_prefix         = string
    kubernetes_version = string

    default_node_pool = object({
      name       = string
      node_count = number
      vm_size    = string
    })
    identity = object({
      type = string
    })

    http_application_routing = object({
      enabled = bool
    })

    oms_agent = object({
      enabled = bool
    })
  })
}

variable "acr_configuration" {
  type = object({
    name          = string
    sku           = string
    admin_enabled = string
  })
}

variable "tags" {
  default = {}
  type    = map(string)
}