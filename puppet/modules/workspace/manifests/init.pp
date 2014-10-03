class workspace{

	file { '/home/vagrant/Workspace/':
	   ensure => 'link',
	   target => '/vagrant',
	}
}