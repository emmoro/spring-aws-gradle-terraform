variable "amis" {
  type = map

  default = {
    "us-east-2" = "ami-0dd0ccab7e2801812" //Amazon Linux 2 AMI (HVM), SSD Volume Type -  (64 bits x86)
  }
}

variable "key_name" {
  type = string
  default = "key"
}