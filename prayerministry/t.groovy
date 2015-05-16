def processScript(rawtxt){

      rawtxt.replaceAll(/\((.*?)\)/){fullmatch,txt->

	return txt.toUpperCase()+" updated na"
            }

}

println processScript("what ever-- (this is in it) --so waht--(anoth one)--")
