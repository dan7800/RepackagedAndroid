class workspace{

	file { [ "/home/vagrant/Workspaces" ]:
    ensure => "directory",
}

	file { '/home/vagrant/Workspaces/RITAndroid':
	   ensure => 'link',
	   target => '/vagrant',
	}
}