Vagrant.configure("2") do |config|

  # Configure base box parameters
  config.vm.define "build" do |build|
    build.vm.box = "build"
    build.vm.hostname = "build"
    build.vm.guest = :windows
  end

  config.vm.network "forwarded_port", guest: 6060, host: 6060
  config.vm.network "forwarded_port", guest: 7070, host: 7070
  config.vm.network "forwarded_port", guest: 8080, host: 8080
  config.vm.network "forwarded_port", guest: 9090, host: 9090

  # Port forward WinRM and RDP
  config.vm.network :forwarded_port, guest: 3389, host: 3389
  config.vm.network :forwarded_port, guest: 5985, host: 5985, id: "winrm", auto_correct: true

  config.vm.provision :shell, inline: "netsh advfirewall firewall add rule name='rule1' dir=in action=allow protocol=TCP localport=6060"
  config.vm.provision :shell, inline: "netsh advfirewall firewall add rule name='rule2' dir=in action=allow protocol=TCP localport=7070"
  config.vm.provision :shell, inline: "netsh advfirewall firewall add rule name='rule3' dir=in action=allow protocol=TCP localport=9090"

  config.vm.provision :shell, :path => "install_net4.ps1"
  config.vm.provision :shell, :path => "install_chocolatey.ps1"

  config.vm.provision :shell, inline: "cinst puppet"
  config.vm.provision :shell, inline: "puppet module install --force rismoney/chocolatey"

  config.vm.provision :puppet do |puppet|
    puppet.manifests_path = ""
    puppet.manifest_file  = "base.pp"
  end

end