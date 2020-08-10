import javax .swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.print.attribute.*;
import java.awt.print.*;
import javax.swing.undo.*;
import javax.swing.event.*;
import j avax.print.attribute.HashPrintRequestAttributeSet; 
import java.util.*;
import java.text.SimpleDateFormat;
public class Notepad extends JFrame implements ActionListener ,  Printable 
{
	JMenuBar mbr ;
	JMenu file, edit, format, view, help;
	JMenuItem New , open,save,saveas,pagesetup,print,exit; 
	JMenuItem undo, cut, copy,paste, delete,find,findnext, replace,g,selectall,time; 
	JMenuItem wordwrap,font;
	JMenuItem statusbar,aboutnotepad,viewhelp;
	JTextArea tal; 
	String content, path= ""; 
	static About abt; 
	static Font_Chooser fc; 
	static Find finder; 
	Notepad()
	{
		setTitle  (“Notepad”);
		setlconlmage(Toolkit.getDefaultToolkit().getImage("a.png");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
		setSize(400, 400) ;
		setVisible(true) ;
		tal = new JTextArea  (10,10);
		tal.setBackground(new Color (255,255,255)) ;
		add(tal);
		mbr = new JMenuBar();
		setJMenuBar(mbr);
		file = new JMenu("File") ; 
		edit =  new JMenu("Edit"); 
		format = new JMenu ("Format"); 
		view = new JMenu("View"); 
		help = new JMenu("Help");
		New = new JMenuItem ("New"); 
		open = new JMenuItem ("Open ..""); 
		save = new JMenuItem ("Save"); 
		saveas = new JMenuItem ("Save As"); 
		pagesetup = new JMenuItem ("Page Setup"); 
		print = new JMenuItem ("Print");
		exit = new JMenuItem ("Exit");
		undo = new JMenuItem ("Undo");
		cut = new JMenuItem  ("Cut") ;
		copy = new JMenuItem  ("Copy");
		paste = new JMenuItem  ("Paste");
		delete = new JMenuItem ("Delete") ;
		find = new JMenuItem  ("Find") ;
		findnext = new JMenuItem ("Find Next") ;
		replace = new JMenuItem  (“Replace”) ;
	 = new JMenuItem  (“Goto”);
	 selectall = new JMenuItem  (“Select All”);
	 time = new JMenuItem  (“Time/Date”);
	 wordwrap = new JMenuItem(“Word Wrap”) ;
	 font = new JMenuItem(“Font”);
	 statusbar = new JMenuItem(“Status Bar”);
	 viewhelp = new JMenuItem(“View Help”); 
	 aboutnotepad = new JMenuItem(“About Notepad”)
	 file.add (New) ;
	 file.add(open); 
file.add(save); 
file.add(saveas); 
file.addSeparator  (); 
file.add(pagesetup); 
file.add(print); 
file.addSeparator (); 
file.add(exit);
file .  add (undo) ;
edit.addSeparator() ; 
edit.add(cut) ; 
edit.add(copy) ; 
edit.add(paste); 
edit.add(delete); 
edit.addSeparator() 
edit .add (find) ; 
edit. add (findnext) ; 
edit.add(replace)/ 
edit.add(g); 
edit.addSeparator (); 
edit.add(selectall); 
edit.add(time); 

format  . add(wordwrap); 
format  .  add(font);
view     . add(statusbar);	
help. add(viewhelp);	
help.addSeparator();	
help.add(aboutnotepad);	
mbr  .	add (file) ;	
mbr  .	add(edit);	
mbr .	add(format);	
mbr  .	add(view);	
mbr  .	add  (help);
	
New .	addActionListener(this);
open .  addActionListener(this) ;
save . addActionListener(this) ;
saveas  . addActionListener(this);

pagesetup . addActionListener(this); 
print . addActionListener(this); 
exit . addActionListener(this); 
undo . addActionListener(this); 
cut . addActionListener(this); 
copy . addActionListener(this); 
paste . addActionListener(this); 
delete . addActionListener(this); 
find . addActionListener (this) ; 
findnext . addActionListener (this) ; 
replace . addActionListener(this);
 selectall . addActionListener(this);
wordwrap.addActionListener(this) viewhelp.addActionListener(this); 
font . addActionListener(this); 
abt = new About (this); 
fc = new FontChooser(this); 
	finder = new Find(this);
	finder . setDefaultCloseOperation (JFrame. EXIT_ON_CLOSE);
	)
	public void actionPerformed(ActionEvent e) 
	(
	if (e.getSource()  == New)
		file_new () ;	
	if(e.getSource()  ==	open)
		file open () ;	
if(e.getSource ()  ==	save)
	file save () ;	
if(e.getSource ()  ==	saveas)
f	ile_save_as () ;	
if(e.getSource ()  ««	pagesetup)
	page setup ();	
if (e.getSource()  ==	print)
	file print () ;	
if (e.getSource()  ==	exit)
	file close ()
if(e.getSource ()  ==	cut)
	edit cut ();	
if (e.getSource()  ==	copy)
	edit_copy()/	
if (e.getSource()  ==	paste)
	edit paste ();	
if(e.getSource ()  ==	delete)
	edit delete() /	
if(e.getSource()  == time)
edit_timedate(); 
	if(e.getSource()  == selectall)
edit_selectall(); 
	if(e.getSource()  == wordwrap)
format_wordwarp(); 
	if (e.getSource()==viewhelp)
help_about (); 
	if (e.getSource()==font)
format_font();
if(e.getSource( == find)
edit_find () ; if
	(e.getSource()==find)
edit_find () ; if 
	(e. get Source () ==findnext)
edit_find_next () ; 
	if(e. get Source () ==findnext)
edit_find_next () ;
)
public void file_new()
(
if (tal.getText() .equals () ;  | |  tal.getText() . 
equals(content) ) 
(
tal.setText (“”);
content = “”;
path = “ ”; 
setTitle(“untitled - Notepad”); 
)
else
(
int a = JOptionPane . showConfirmDialog (null, 
“The text has been changed\nDo you want
to save the changes?”);
if (a==0)
file_save () ;
else if(a==1)
(
tal.setText (“”); 
path = “”; 
setTitle(“untitled - Notepad”);
	)
	else if(a==2) return;
)
)
public void file_save() 
(
System.out.print(“Helloooooo”); 
if (path.equals(“ “)’
file_save as () ;
	return;
)
try 
(
FileWriter fw = new FileWriter (path) 
fw.write(tal.getText());
content = tal.getText() ; 
fw.close ();
)
catch(IOException i) 
(
JOptionPane.showMessageDialog 
(this, “Failed to save the file”, “Error”, JOptionPane.ERROR_MESSAGE) ;
)
)
public void file_save_as () 
(
JFileChooser fc = new JFileChooser() ; 
fc. setFileSelectionMode (JFileChooser. FILES ONLY) 
int r = fc.showSaveDialog(this) ; 
if(r==JFileChooser.CANCELJDPTION) 
return;
File myfile = f c. getSelectedFile () ; 
System, out .println (myfile) ;
if (myfile==null   II myfile . getName (). equals (“”) ) 
(
JOptionPane.showMessageDialog 
(this, “Please enter a file name!”, “Error”, JOptionPane.ERROR_MESSAGE) ;
return;
)
if (myfile. exists () )
(	r = JOptionPane. showConfirmDialog(this, “A
file with same name already exists!\nAre 
you sure want to overwrite? );
if(r  != 0)
return;
)
try
(

FileWriter fw = new FileWriter (myfile) ;
fw.write(tal.getText 0);
content = tal.getText();
setTitle (myfile. getName()+” - Notepad”);
fw.close ();
)
catch (IOException e)\
(
JOptionPane.showMessageDialog
(this, “Failed to save the file”, “Error”,
JOptionPane.ERROR_MESSAGE);
)
)
public void file__open() 
(
JFileChooser fc = new JFileChooser (); fc.setFileSelectionMode(JFileChooser. 
FILES_ONLY);
int r=fc.showOpenDialog(this); if (r==fc.CANCEL_OPTION) 
return;
File myfile - fc.getSelectedFile () ;
if (myfile == null I I myfile . getName () . equals (“”))
(
JOptionPane.showMessageDialog
(this,  “Select a file!”,  “Error”, JOptionPane.ERROR_MESSAGE);
return;
)
try 
(
BufferedReader input = new BufferedReader 
(new FileReader (myfile) ) ; StringBuffer str = new StringBuffer() : String line;
while ((line = input. readLine ())   != null) //
st is declared as string avobe
str.append(line+”\n”);
tal.setText(str.toString ()); 
content = tal.getText (); 
path = myfile. toString () ; 
setTitle (myfile. getName ()+” - Notepad”)
)
catch(FileNotFoundException e)
(
JOptionPane.showMessageDialog (null, “File 
not found:  “+e);
)
catch (IOException e)

JOptionPane.showMessageDialog(null, 
“IO ERROR:  “+e);
)
)
public void page_setup() 
(
PrinterJob job = PrinterJob.getPrinterJob() ;
PrintRequestAttributeSet aset = new
HashPrintRequestAttributeSet() ;
PageFormat pf = job.pageDialog(aset); 
job.setPrintable(obj, pf) ;
boolean ok = job.printDialog(aset); if (ok)
(
try 
(
job.print(aset); 
)
catch  (PrinterException ex) 
(
/* The job did not successfully complete */ 
)
)
//System.exit (0) ; 
)
Public int print(Graphics g, PageFormat pf, int 
Page) throws PrinterException
(

If(page > 0) 
(
/* We have only one page, and ‘page’ is zero-based
return NO SUCH PAGE;
)
/* User (0,0)  is typically outside the imageable
area,  so we must
* translate by the X and Y values in the
PageFormat to avoid clipping
*/
Graphics2D g2d =  (Graphics2D)g; 
g2d.translate(pf.getlmageableX (), 
pf.getlmageableY()); /* Now we perform our rendering */ g.drawstring(tal.getText(),  100,  100); 
/* tell the caller that this page is part of 
the printed document */ 
return PAGE_EXISTS; 
	)
public void file_print() 
(
PrinterJob printer = PrinterJob.getPrinterJob() ; 
//printer.setPrintable ( this);
HashPrintRequestAttributeSet printAttr = new HashPrintRequestAttributeSet(); 
printer.setPrintable(obj); 
if (printer.printDialog(printAttr))   // Display 
print dialog 
(
// If true is returned...
try 
(
printer.print(printAttr);  // then print 
)
catch(PrinterException e) 
(
JOptionPane.showMessageDialog (this, 
“Failed to print the file: “+e, “Error”, JOptionPane.ERROR_MESSAGE);
	)
)
)
public void file close () 
(
if(tal.getText0 .equals(content))
(
tal.setText(“”) ; 
path = «”.
System.exit(0);
)
else if (tal. getText () . equals (“ “) &&content==null)
(
tal.setText (“ ”);
path = “ ”;
System.exit (0);
)
else 
(
int a = JOptionPane. showConfirmDialog \
(null,   “The text has been changed\nDo you 
want to save thechanges?”);
if(a==0) 
file_save () ;
else if(a==l)
(
tal.setText(“”) ; 
path = “ ”;
setTitle(“untitled - Notepad”);
)
else if (a==2) 
return;
)
)
public void edit_cut() 
(
tal.cut ()   ; 
)
public void edit_copy() 
)
tal.copy(); 
)
public void edit_paste() {
(
tal.paste(); 
	  )
public void edit_delete () 
(
String temp = tal.getText0 ; 
tal.setText(temp.substring(0,  tal. 
getSelectionStart () ) +temp. substring
 (tal.getSelectionEnd()));
)
public void edit_selectall() 
(
tal.selectAll(); 
)
public void edit_timedate() 
(
try 
(
int start = tal.getSelectionStart() ; 
int end = tal.getSelectionEnd(); 
Calendar cal = Calendar.getlnstance();
SimpleDateFormat sdf = new SimpleDateFormat (“dd/mm/yyyy h:m a”);
String now = % sdf.format(cal.getTime());
String tempi = tal.getText () .
substring(0, start); 
String temp2 = tal.getText () . 
substring(end);
tal.setText(templ+” “+now+” “+temp2); 
tal.select(start+1, start+l+now.length()) ;
)
catch(NullPointerException e)
(
)
)
public void format_wordwarp() 
(
if(tal.getLineWrap()==false) 
tal.setLineWrap(true); 
else
tal.setLineWrap(false);
)
public void help_about() 
(
abt.window.setVisible(true);
)
public void format font() 
(
fc.window.setVisible(true);
)
public void edit_find()
(
finder. setVisible (true) ; 
)
public void edit_find_next () 
(
finder. find_next () ; 
)
public void edit_replace() 
(
finder. setVisible (true) ; 
)
static Notepad obj;
public static void main(String[]  args) 
(
obj = new Notepad();
obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
obj.setVisible(true) ;
)
)
Find. java
import java.awt.Checkbox;
import j ava.awt.GraphicsEnvironment;
import java.awt.Label;
import java.awt.Point;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import j ava.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
Public class Find extends JFrame implements ActionListener 
(
int startlndex=0; 
Label 11,  12; 
TextField tf,  tr;
JButton find_btn, find_next, replace, replace_all, cancel; 
Notepad samp;
public Find(Notepad mynote) 
(
super (“find / Replace”);
samp = mynote;
	11 = new label (“find  What: “);
	12 = new Label (“Replace with : “);
	tf = new TextField (30);
	tr = new TextField (30);
	find _btn = new JButton (“find”);
	 find_next = new JButton (“find Next”);
	replace = new JButton (“Replace”);
replace_all = new JButton (“Replace All”); 
cancel = new JButton(“Cancel”);

setLayout(null);
 int label_w = 80; 
int label_h = 20;
int tf_w = 120;
11.setBounds(10,10,  label_w,  label_h); 
add(11);
tf.setBounds(10+label_w,   10,  tf_w,  20); 
add(tf);
12. setBounds(10, 10+label_h+10, label_w, label_h) ; 
add(12);
tr.setBounds(10+label_w,  10+label_h+10,  tf_w, 20); 
add(tr);

find_btn. setBounds (220,   10,   100,  20); 
add (find_btn) ;
find_btn.addActionListener(this) ; 
find_next. setBounds (220,  30,   100,   20); 
add (find_next) ;
find_next. addActionListener (this) ; 
replace.setBounds(220,  50,  100,  20); 
add(replace); 
replacel.addActionListener(this);
replace_all.setBounds(220,  70,  100,  20);
 add(replace_all) ;
replace_all.addActionListener(this); 
cancel.setBounds(220,   90,  100,  20); 
add(cancel) ;
cancel.addActionListener(this); 
int w = 340; 
int h = 150;
setSize (w,h);
// set window position 
Point center = GraphicsEnvironment .
setLocalGraphicsEnvironment() 
getCenterPoint();
setLocation(center.x-w/2, center.y-h/2); 
setVisible(false);
)
public void actionPerformed (ActionEvent e) 
(
if (e.getSource () ==find__btn) 
(
find () ; 
)
else if (e.getSource ()  == find_next) 
(
find_next () ;
)
else if(e.getSource ()  == replace) 
(
replace (); 
)
else if(e.getSource ()  == replace_all) 
(
replace_all();
	)
else if(e.getSource ()  == cancel) 
(
this.setVisible(false); 
		)
	)
public void find() 
	(
int select_start = samp, tal .getText () . 
indexOf(tf.getText() ) ; 
if (select_start == -1)
(

startlndex =0;
JOptionPane. showMessageDialog (null, 
“Could not find “+tf. getText () + “!”);
return;
)	
if (select start — samp.tal.getText().
lastlndexOf(tf.getText())) 
	(
startlndex = 0;
	)
int select_end = select_start+tf. 
getText () .       length ();
samp.tal.select<select_start,  select_end)
	)
public void find_next()
(
String selection = samp. tal.getSelectedText ().
try
(
selection.equals(“”);
)
catch(NullPointerException e) 
	(
selection = tf.getText ();
try
(
selection.equals(“”); 
	)
catch(NullPointerException e2) 
	(
selection = JOptionPane. 
showInputDialog (“find: “) ;
tf.setText(selection);
)
)
try 
(
int select_start = samp.tal.getText(). 
indexOf(selection, startlndex); 
int select_end = select_start+selection. 
length () ;
samp. tal. select (select_start, select__end)
startlndex = select_end+l; 
if(select_start == samp.tal.getText () . 
lastlndexOf(selection))
(
	startlndex = 0;
	)
catch(NullPointerException e)
	()
)
public void replace () 
(
try 
(
find () ;
samp.tal.replaceSelection (tr.getText());
)
catch(NullPointerException e) 
	(
System.out.print (“Null Pointer Exception: “+e) ;
)
)
public void replace_all() 
(
samp.tal.setText(samp.tal.getText() . 
replaceAll(tf.getText (),  tr.getText() ) );
)
)
----------------------------------------------------------------------------------------------------------------
Font_Chooser. java
import java.awt.*; 
import java.awt.event.*; import java.util.Vector; 
import javax.swing.*;
import j avax.swing.border.LineBorder;
import javax.swing.event.*;	
public  class  Font_Chooser   implements  Action Listener
ListSelectionListener
	(
static JFrame window = new JFrame (“Font Chooser”);
Notepad samp;
JLabel flist_label,  fsize_label,  fstyle_label,
fprev_label, preview;
JList flist,  fsize,  fstyle;
ScrollPane flist_sc,  fstyle_sc,  fsize_sc;
JButton ok,  cancel;
GraphicsEnvironment ge;  // graphics env 
String font_names[];  // font names array
Font sample;
String font_name;
int font_size, font__style;
public Font Chooser(Notepad ref)
(
samp = ref;
window.setLayout(null) ;
// creating font name list
ge=GraphicsEnvironment.getLoca1GraphicsEnvironment();
font_names = ge.getAvailableFontFamilyNames();
flist = new Jlist(font_names);
     Flist. setSelectionMode(ListSelectionModel.SINGLE 
SELECTION);
flist_label = new JLabel (“Font:  “) ;
window. add (flist_label) ;
flist_label. setBounds (10,  10,  120,   20);
flist_sc = new ScrollPane () ;
flist_sc. add (flist) ;
flist_sc. setBounds (10,  30,  120,  200); 
window. add (flist_sc) ;
    flist. addListSelectionListener (this) ;
// font style box
String styles[ ]  =  (“Regular”,  “Bold”,  “Italic”,
 “Bold Italic”); 
fstyle = new JList (styles); 
    fstyle.setSelectionMode(ListSelectionModel.SINGLE 
SELECTION);
fstyle_label = new JLabel(“Style:  “) ;
window.add(fstyle_label);
fstyle_label.setBounds(140,  10,  80,  20);
fstyle_sc = new ScrollPane ();
fstyle_sc.add(fstyle);
fstyle_sc.setBounds(140,  30,  80,  70);
window.add(fstyle_sc);
      fstyle.addListSelectionListener(this); 
// font size box
Vector<String> a = new Vector<String>(40, 1); 
For (int I = 8; I <= 100; I + = 21)
     a.addElement (String.valueOf(i));
	fsize = new JList (a);
     fsize.setSelectionMode (ListSelectionModel.SINGLE_
SELECTION);
fsize_label = new JLabel(“Size:  ;)
fsize_label.setBounds (140,  no,  80,  20); 
window.add(fsize_label); 
fsize_sc = new ScrollPane(); 
fsize_sc.add(fsize);
fsize_sc.setBounds (140,  130,  80,  100); 
window.add(fsize_sc);
       fsize.addListSelectionListener(this) ;
// ok and cancel button
ok = new JButton(“OK”); 
ok.setBounds(230,  30,  75,  20);
 ok.addActionListener (this);
window.add(ok) ;
cancel = new JButton(“Cancel”) ; 
cancel.setBounds(230,    50,   75,  20); cancel.addActionListener(this);
window.add(cancel);
fprev_label = new JLabel (“Preview:  “);
fprev__label. setBounds (10,  230,  300,  20);
window.add(fprev_label);
// preview
preview = new JLabel(“Sample Text”); 
preview.setBounds(10,  250,  290,  85);
preview.setHorizontalAlignment (SwingConstants . 
CENTER); 
preview.setOpaque(true);
preview.setBackground(Color.white);
preview.setBorder(new LineBorder (Color.black, 1)) ;
window.add(preview);
int w = 320;
int h = 380; 
window.setSize(w,h);
// set window position
Point center = GraphicsEnvironment.
getLocalGraphicsEnvironment().getCenterPoint() ; window.setLocation(center.x-w/2,  center.y-h/2+25) ; window.setDefaultCloseOperation (JFrame . HIDE_ON_
CLOSE);
window.setVisible (false) ;
	)
	Public void actionPerformed(ActionEvent   e)
	(
	if (e.getSource 0 —ok) 
ok();
else if (e.getSourceO—cancel)
   cancel ();
   )
   public void vaiueChanged(ListSelectionEvent 1) 
  (
if (1.getSource()—flist)
(
	preview. setText ( flist.getSelectedValue () . 
toString ()   ); 
changeFontSample(); 
	)
	else if(1.getSource()==fsize) 
	(
   changeFontSample ();
	     )
   	     else if(1.getSource()==fstyle)
	     (
     changeFontSample()/
                 )
     (
     private void changeFontSample () 
    (
try 
(
font_name - flist. getSelectedValue () . toString () ; 
)
      catch(NullPointerException npe) 
		  (
font_name = “Verdana”;
)
try 
(
font_style = getStyle();
		 )
    catch(NullPointerException npe) 
		(
(font_style = Font.PLAIN.
font_size = Integer.parselnt(fsize . getSelectedValue().toString() ) •
)
catch(NullPointerException npe) {
font_size =12;
(
sample = new Font(font_name, font_style, font size); preview.setFont(sample) ; }
private int getStyle() 
(
if( fstyle.getSelectedValue().toString() . 
eguals(“Bold”)   )
return Font.BOLD;
 if(fstyle.getSelectedValue().toStringO. 
equals(“Italic”)   )
return Font.ITALIC; i
f(fstyle.getSelectedValue() .toString() . 
equals(“Bold Italic”))
return Font.BOLD+Font.ITALIC; 
return Font.PLAIN;
)
private void ok() 
(
try 
(
samp.tal.setFont (sample); 
)
catch(NullPointerException npe) ()
this.window.setVisible (false); 
	)
private void cancel() 
(
this.window.setVisible (false); 
)
)
-----------------------------------------------------------------------------------------------------------------
About.java
import javax.swing.*;
import java.awt.*; 
import java.awt.event.*; 
Public class About {

static JFrame window = new jFramepAbout Notepad”); 
Notepad samp; 
JButton btn;  
public About(Notepad ref) 
(
samp = ref;	
//Container c = window.getContentPane ();
JPanel p1 - new jPaneK); 
P1.setLayout(new FlowLayout ()) .
String About = “<html>” + 
“<body>” +
“Created By...<br>” + 
“Bishnu Barik <br>” + 
“LITINDIA<br>” +
“Computer Science & Engineering<br>    +
“BPUT<br><br><br>” +
“Contact:  09937917604<br>” +
“E-Mail: barikbishnul92@gmail.com<br>” +
“Web: http://www. litindia. in<br><br>” +
“Version:  10.0 jdk<br>” +
“Built Date: “+new java.util. Date () +”<br><br><br>” +
“</body>” +
“</html>”;
//ImageIcon icon = new ImageIcon (“author.jpg”),’ 
JLabel 1 = new JLabel (); 
1. setText(About);
//1. setVerticalTextPosition (SwingConstants . TOP) ;
//.setlconTextGap (20) ;
P1.add(1);
int w = 340;
int h = 350;
window.setSize(w,h);
// set window position
Point center = GraphicsEnvironment.
getLocalGraphicsEnvironment () . getCenterPoint ();
window.setLocation(center.x-w/2,  center.y/2) ; 
window. setDefaultCloseOperation(JFrame. HIDE_ON_ 
CLOSE);
window.setVisible(false); 
window.add(pi)•
)
)
