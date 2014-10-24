# -*- mode: ruby -*-
# vi: set ft=ruby :

Vagrant.configure("2") do |config|
  config.vm.box = "ubuntu/trusty64"
  config.vm.network :forwarded_port, guest: 8080, host: 9090

  config.omnibus.chef_version = "11.16"
  config.berkshelf.enabled = true

  config.vm.provision :chef_solo do |chef|
    chef.add_recipe "apt"
    chef.add_recipe "java"
    chef.add_recipe "maven"
    chef.add_recipe "tomcat"
    chef.json = {
      "java" => {
        "jdk_version" => "7",
      },
      "maven" => {
        "version" => "3",
      },
      "tomcat" =>{
        "base_version" => "7",
      }
    }
  end
end

