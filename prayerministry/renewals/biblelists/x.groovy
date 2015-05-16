def rawtxt=new File("scriptslists/KJV/myrelationshiptoothers/s54.txt").getText("UTF-8")
	def verse
	def matched
	 rawtxt.replaceAll(/\((.*?)\)/){fullmatch,txt->
	matched=fullmatch
	verse=txt
	}
	println rawtxt
	println matched
	println verse
	//	p.insert([txt,version,rawtxt-fullmatch,folder])
