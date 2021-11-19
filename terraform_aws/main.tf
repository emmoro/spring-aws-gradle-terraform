provider "aws" {
  alias  = "east"
  region = "us-east-2"
}

//ec2
resource "aws_instance" "dev" {
  ami = var.amis["us-east-2"]
  instance_type = "t2.micro"
  key_name = var.key_name
  tags = {
      Name = "dev"
  }
  vpc_security_group_ids = ["sg-xxxxxxxxxxxxxxxxx"] //security group id

  user_data = <<-EOF
    #!/bin/bash
    sudo yum update -y
    sudo amazon-linux-extras install -y java-openjdk11
    chmod 777 /home/ec2-user/server_stop.sh
    chmod 777 /home/ec2-user/server_start.sh
    sudo /home/ec2-user/./server_start.sh
  EOF

/* script use image docker
  user_data = <<-EOF
    #!/bin/bash
    sudo yum update -y
    sudo yum install docker -y
    sudo service docker start
    sudo usermod -a -G docker ec2-user
    sudo amazon-linux-extras install -y java-openjdk11
    sudo docker run -d -p 8180:8180 emmoro/app-aws-terraform:v1
  EOF
  */

  connection {
      type        = "ssh"
      host        = "${aws_instance.dev.public_ip}"
      user        = "ec2-user"
      private_key = "${file("C:/app/key.pem")}"
      timeout     = "2m"
  }
  
  provisioner "file" {
    source      = "C:/spring-aws-gradle-terraform/script/server_start.sh"
    destination = "/home/ec2-user/server_start.sh"
  }

  provisioner "file" {
    source      = "C:/spring-aws-gradle-terraform/script/server_stop.sh"
    destination = "/home/ec2-user/server_stop.sh"
  }

  provisioner "file" {
    source      = "C:/spring-aws-gradle-terraform/build/libs/app-aws-terraform.jar"
    destination = "/home/ec2-user/app-aws-terraform.jar"
  }

}

