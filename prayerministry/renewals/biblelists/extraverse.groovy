
def dest="scriptslists/"
def folders=["myrelationshiptoothers","myrelationtogod","theattributeofgod","thecharacteriwanttocultivate","workofgod"] as Set
folders.each{folder->
def v=new StringBuilder()
def token=
new File(folder).eachFile{f->
def rawtxt=new File(f.path).getText("UTF-8")
	 rawtxt.replaceAll(/\((.*?)\)/){fullmatch,txt->
	v<<"("+txt+")\n "
        }

}
println v.toString()
try{
def writer= new File(dest+folder+"/"+fil).newWriter("UTF-8",true)
writer.write(v.toString());
writer.close()
}catch(Exception e){}
}
