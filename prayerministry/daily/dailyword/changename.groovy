(0..94).each{i->
def nm="prayer${i}"
new File(nm+".htm").renameTo("day${i}.htm")
new File(nm+".pdf").renameTo("day${i}.pdf")
new File(nm+".xml").renameTo("day${i}.xml")
}
