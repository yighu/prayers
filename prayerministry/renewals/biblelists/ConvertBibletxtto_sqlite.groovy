def version="ChiNCVt"
//version="KJV"
def p=new PersistStatistic()
def dest="scriptslists/${version}/"
def folders=["myrelationshiptoothers","myrelationtogod","theattributeofgod","thecharacteriwanttocultivate","workofgod"] as List
folders.each{folder->
def i=0;
def target=dest+folder
println folder +"  "+target
new File(target).eachFile{fl->
println fl.path
def vers
def matched
def rawtxt=new File(fl.path).getText("UTF-8")
	 rawtxt.replaceAll(/\((.*?)\)/){fullmatch,txt->
	matched=fullmatch
	vers=txt
	}
		p.insert([i++,vers,version,rawtxt-matched,folder])
	}
}
