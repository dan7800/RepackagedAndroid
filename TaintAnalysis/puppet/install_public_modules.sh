#installs modules right on the vm
mkdir -p /etc/puppet/modules;
puppet module install puppetlabs/ntp;
puppet module install puppetlabs-java
puppet module install maestrodev-android;