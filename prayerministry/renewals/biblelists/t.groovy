def processScript(rawtxt,version){

      rawtxt.replaceAll(/\((.*?)\)/){fullmatch,txt->
	def result=new StringBuilder()
	println "ref:"+txt
	txt.split(";").each{scpt->	
	try{
	result<<fetchVerses(version,cleanText(scpt))+" "
	}catch(Exception e){
		println "verse:"+scpt
	}
	}
	return result.toString()+ " ($txt)"
            }

}
def version="ChiNCVt"
version="KJV"
def p=new PersistStatistic()
def dest="scriptslists/${version}/"
def folders=["myrelationshiptoothers","myrelationtogod","theattributeofgod","thecharacteriwanttocultivate","workofgod"] as Set
folders.each{folder->
int i=1
new File(dest+"/"+folder).eachFile{f->
def rawtxt=new File(f.path).getText("UTF-8")
 rawtxt.replaceAll(/\((.*?)\)/){fullmatch,txt->
	println rawtxt-fullmatch+" /"+txt
}
}
}
