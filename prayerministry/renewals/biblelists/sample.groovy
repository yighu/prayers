import org.crosswire.common.xml.*
import java.io.*;
import groovy.xml.MarkupBuilder
import org.crosswire.jsword.book.*
import java.net.MalformedURLException;
import java.net.URL;
import com.google.gson.*;
import org.crosswire.jsword.book.sword.SwordBookPath
import org.crosswire.jsword.index.IndexManagerFactory
import org.crosswire.jsword.passage.Key
import org.crosswire.jsword.passage.NoSuchKeyException
import org.crosswire.jsword.passage.Passage
import org.crosswire.common.util.Translations;
import org.crosswire.bibledesktop.passage.KeyTreeModel
import org.crosswire.jsword.util.ConverterFactory
import org.crosswire.jsword.versification.BibleInfo
import org.crosswire.jsword.bridge.BookInstaller
import org.xml.sax.ContentHandler
import org.xml.sax.SAXException
import grails.converters.*
import org.crosswire.common.util.NetUtil;
import org.crosswire.common.util.ResourceUtil;
import java.text.SimpleDateFormat;
import org.crosswire.jsword.book.Defaults;
import org.crosswire.bibledesktop.desktop.XSLTProperty
import org.crosswire.jsword.versification.BibleNames
import org.apache.poi.hslf.usermodel.SlideShow
import org.apache.poi.hslf.model.Slide
import org.apache.poi.hslf.model.TextBox
import org.apache.poi.hslf.usermodel.RichTextRun
import javax.servlet.http.HttpSession;

def shortnames_eng=[" ","Gen",
"Exo",
"Lev",
"Num",
"Deu",
"Josh",
"Judg",
"Ruth",
"1Sam",
"2Sam",
"1Ki",
"2Ki",
"1Ch",
"2Ch",
"Ezr",
"Neh",
"Est",
"Job",
"Psa",
"Pro",
"Ecc",
"Song",
"Isa",
"Jer",
"Lam",
"Eze",
"Dan",
"Hos",
"Joe",
"Amo",
"Obd",
"Jon",
"Mic",
"Nah",
"Hab",
"Zep",
"Hag",
"Zec",
"Mal",
"Mat",
"Mar",
"Luk",
"Joh",
"Act",
"Rom",
"1Cor",
"2Cor",
"Gal",
"Eph",
"Phili",
"Col",
"1Th",
"2Th",
"1Ti",
"2Ti",
"Titus",
"Phil",
"Heb",
"Jam",
"1Pe",
"2Pe",
"1Jo",
"2Jo",
"3Jo",
"Jude",
"Rev"] as List

      int nbook = BibleInfo.booksInBible();
      BibleNames bn = new BibleNames(Locale.US)

	println "nbook:"+nbook
      try {
        for (int i = 1; i <= nbook; i++)

        {
	def gb=new Expando()
          gb.key = shortnames_eng.get(i)
	  gb.shortkey=BibleInfo.getBookName(i).getShortName()
          gb.shortname = bn.getShortName(i)
          gb.cname = bn.getName(i)
          gb.longname = BibleInfo.getBookName(i).getLongName()
	  println "key:"+gb.key +" shortkey:"+gb.shortkey+" "+gb.shortname+" "+gb.cname+" "+gb.longname
        }


      } catch (Exception e) {
	e.printStackTrace()
      }
