import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
import java.applet.AudioClip;
     import java.awt.event.ItemListener;
     import java.awt.event.ItemEvent;
     import java.awt.event.ActionListener;
     import java.awt.event.ActionEvent;
     import java.awt.FlowLayout;
     import javax.swing.JApplet;
         import javax.swing.JButton;
    import javax.swing.JComboBox;

/** secret phrase class */
public class BOLLYWOOD extends JApplet implements ActionListener{
    private AudioClip sound1, sound2, currentSound;
      private JButton playJButton, loopJButton, stopJButton;
      private JComboBox soundJComboBox;
      JLabel txt;
	    Image background;
	    
	        Image background1;
	        java.net.URL backgroundURL;
	        java.net.URL backgroundURL1;
	        Container ck = getContentPane();
    //declaring componets
    JLabel titlelb = new JLabel("                         Bollwood Game                    ");
    JLabel directionslb = new JLabel("Play our game - guess the Film   Enter one letter");
    JLabel secretlb = new JLabel();
    JLabel secretb = new JLabel();
       JLabel as = new JLabel();
       JLabel statuslb = new JLabel();
    JButton[] letterbn = new JButton[26];   
    int r;
    //get content pane of applet
    Container con = getContentPane();
    
    //initialize random class
    Random rand = new Random();
    
    //constant holds the ordinal values of A
    final int FIRST_CHAR = 65;
    
    //constant holds value of max phrases
    final int PHRASE_MAX = 5;
    
    //initializing array of phrases
    String[] arrayList = new String[1000];
    String[] arayList = new String[1000];
    //string that will old the mask text
    String secret;    
    
    //string that will hold the answer key
    String choice;
    
    //initialize letter to hold the first character of the alphabet
    int letter = FIRST_CHAR;    
    int c=0;
    int l;
    String q="";
String s="BOLLYWOOD";
    /** applet initiation method */
    public void init(){
        setForeground(Color.red);
        sound1 = getAudioClip( getDocumentBase(), "Shahrukh-Khan-(Megamix)-DJ-Varun-(Pagalworld.Com).wav" );
            
            currentSound = sound1;
              currentSound.play();
              JPanel p = new JPanel();
	        
	                backgroundURL=this.getClass().getResource("100yearsofcinema-movie-630-.jpg");
	        background=getImage(backgroundURL);
	    txt=new JLabel("TEST");
	    	        getContentPane().add(txt);
	    	         backgroundURL1=this.getClass().getResource("BHjUyMQCEAAK5Vl.jpg");
	        background1=getImage(backgroundURL1);
	    txt=new JLabel("TEST");
	    	        getContentPane().add(txt,BorderLayout.CENTER);
        //set text for the string array
        arrayList[0] = "CHAAHAT";
        arrayList[1] = "MERA NAAM JOKER";
        arrayList[2] = "SAAWAN AYA JHOOM KE";
        arrayList[3] = "KAHO NAA PYAAR HAI";
        arrayList[4] = "ALL THE BEST";
        arrayList[5] = "MERE BROTHER KI DULHAN";
        arrayList[6] = "I HATE LOVE STORY";
        arrayList[7] = "AB TUMHARE HAWALE VATAN SAATHIYO";
        arrayList[8] = "BUDDHA HOGA TERA BAAP";
        arrayList[9] = "TUMKO NA BHOOL PAENGE";
        arrayList[10] = "HUM AAPKE DIL MEIN REHTE HAIN";
        arrayList[11] = "PAATHSHALA";
        arrayList[12] = "KUCH KUCH HOTA HAI";
        arrayList[13] = "DELHI BELLY";
        arrayList[14] = "HUMRAAZ";
        arrayList[15] = "HADH KAR DI AAPNE";
        arrayList[16] = "HUMKO DEEWANA KAR GAE";
        arrayList[17] = "MUSAFIR";
        arrayList[18] = "EK PHOOL DO MALI";
         arrayList[19] ="TUMSE ACHHA KAUN HAI";
          arrayList[20] ="AASHIQ HOON BAHARON KA";
        arayList[0] = "SHAH RUKH KHAN";
        arayList[1] = "RAJ KAPOOR";
        arayList[2] = "DHARMENDRA";
        arayList[3] = "HRITIK ROSHAN";
        arayList[4] = "AJAY DEVGAN";
       arayList[5] = "IMRAN KHAN";
       arayList[6] = "IMRAN KHAN";
       arayList[7] = "BOBBY DEOL";
       arayList[8] = "AMITABH BACHCHAN";
       arayList[9] = "SALMAN KHAN";
        arayList[10] = "ANIL KAPOOR";
        arayList[11] = "SHAHID KAPOOR";
        arayList[12] = "SHAH RUKH KHAN";
        arayList[13] = "IMRAN KHAN";
       arayList[14] = "AMISHA PATEL";
       arayList[15] = "GOVINDA";
       arayList[16] = "AKSHAY KUMAR";
       arayList[17] = "ISWAR LAL";
       arayList[18] = "BALRAJ SAHANI";
       arayList[19] = "SHAMMI KAPOOR";
       arayList[20] = "RAJESH KHANNA"; 
        choice = randomStr(arrayList,21);
     
        secret = maskStr(choice);
        l=secret.length();
        
 
        //set labels font
        titlelb.setFont(new Font("JOKERMAN", Font.BOLD, 72));
        directionslb.setFont(new Font("ALGERIAN", Font.BOLD, 40));
     secretb.setFont(new Font("CHILLER", Font.BOLD, 48));
     secretlb.setFont(new Font("Garrmond",Font.BOLD, 60));
        secretb.setText(s);
        //get secret label text
        as.setText("HINT :"+arayList[r]);
         secretlb.setText(secret);
        //add componets to container
        p.add(titlelb);
        p.add(directionslb);
        p.add(secretb);
        p.add(secretlb);
        p.add(as);
        p.add(statuslb);
        
        //initializing buttons
        for( int x = 0; x < 26; x++ ){
            letterbn[x] = new JButton(Character.toString((char)(letter + x)));
            letterbn[x].addActionListener(this);
            p.add(letterbn[x]);
        }
       
        //set FlowLayout as the layout for the container
        p.setLayout(new FlowLayout());
        ck.add(p);
	//visible 
        this.setVisible(true);
            
    }
    
    /** function to catch actions */
    public void actionPerformed(ActionEvent e){
       
        if(isMasked(secret)||c<9){
            
            Object source = e.getSource();
       
            if(source == letterbn[0]){
                letterbn[0].setEnabled(false);
                reveal('A', choice);
            }
            if(source == letterbn[1]){
                letterbn[1].setEnabled(false);
                reveal('B', choice);            
            }
            if(source == letterbn[2]){
                letterbn[2].setEnabled(false);
                reveal('C', choice);            
            }
            if(source == letterbn[3]){
                letterbn[3].setEnabled(false);
                reveal('D', choice);            
            }       
            if(source == letterbn[4]){
                letterbn[4].setEnabled(false);
                reveal('E', choice);            
            }       
            if(source == letterbn[5]){
                letterbn[5].setEnabled(false);
                reveal('F', choice);            
            } 
            if(source == letterbn[6]){
                letterbn[6].setEnabled(false);
                reveal('G', choice);            
            } 
            if(source == letterbn[7]){
                letterbn[7].setEnabled(false);
                reveal('H', choice);            
            }
            if(source == letterbn[8]){
                letterbn[8].setEnabled(false);
                reveal('I', choice);            
            }
            if(source == letterbn[9]){
                letterbn[9].setEnabled(false);
                reveal('J', choice);            
            }
            if(source == letterbn[10]){
                letterbn[10].setEnabled(false);
                reveal('K', choice);            
            }
            if(source == letterbn[11]){
                letterbn[11].setEnabled(false);
                reveal('L', choice);            
            }
            if(source == letterbn[12]){
                letterbn[12].setEnabled(false);
                reveal('M', choice);            
            }
            if(source == letterbn[13]){
                letterbn[13].setEnabled(false);
                reveal('N', choice);            
            }
            if(source == letterbn[14]){
                letterbn[14].setEnabled(false);
                reveal('O', choice);            
            }
            if(source == letterbn[15]){
                letterbn[15].setEnabled(false);
                reveal('P', choice);            
            }
            if(source == letterbn[16]){
                letterbn[16].setEnabled(false);
                reveal('Q', choice);            
            }
            if(source == letterbn[17]){
                letterbn[17].setEnabled(false);
                reveal('R', choice);            
            }
            if(source == letterbn[18]){
                letterbn[18].setEnabled(false);
                reveal('S', choice);            
            }
            if(source == letterbn[19]){
                letterbn[19].setEnabled(false);
                reveal('T', choice);            
            }
            if(source == letterbn[20]){
                letterbn[20].setEnabled(false);
                reveal('U', choice);            
            }
            if(source == letterbn[21]){
                letterbn[21].setEnabled(false);
                reveal('V', choice);            
            }
            if(source == letterbn[22]){
                letterbn[22].setEnabled(false);
                reveal('W', choice);            
            }
            if(source == letterbn[23]){
                letterbn[23].setEnabled(false);
                reveal('X', choice);            
            }
            if(source == letterbn[24]){
                letterbn[24].setEnabled(false);
                reveal('Y', choice);            
            }
            if(source == letterbn[25]){
                letterbn[25].setEnabled(false);
                reveal('Z', choice);            
            }
       }
        else
            JOptionPane.showMessageDialog(null, "The Puzzle has already been solved!");
    }
    
    /** reveals a character in secret label */
    private void reveal(char letter, String str){        
        
        //ensure str is all caps
        str = str.toUpperCase();
       
        //if the letter is not convert it to uppercase
        if(Character.isLowerCase(letter))
            letter = Character.toUpperCase(letter);
        
        //if the character is within the string display correct else display not in phrase message
        if( str.indexOf(letter) != -1)
            statuslb.setText("Correct");
        else
        {
            statuslb.setText("Sorry - not in the phrase: " + letter);
            c++;
        if(c<9)
        {
            
           
            
           
            secretb.setText(s.substring(c));
        }
    }
        //loop and replace the selected masked character in secret
        for(int x = 0; x < str.length(); x++){            
            if(str.charAt(x) == letter)
                secret = replaceCharAt(secret,x,letter);                                             
        }
        
        //show the new secret string in secret label
        secretlb.setText(secret);
        
        //if the secret is not masked displayed display winning message
        if(!isMasked(secret)){
            JOptionPane.showMessageDialog(null,"Congratulations!");
            stop();
        }
        if(c>=9)
        {
        JOptionPane.showMessageDialog(null,"YOU LOOSE!!!!!!  TRY AGAIN!!!!!");
        JOptionPane.showMessageDialog(null,"RIGHT ANSWER IS :"+arrayList[r]);
        stop();
    }
}
  
    /** returned a masked string */
    public String maskStr(String str){       
        for(int x = 0; x < str.length(); x++){
            if(str.charAt(x) != ' ')
            {
                str = replaceCharAt(str,x,'x');
               
            }
            
        }
        return str;
    }   
    
    /** returns a string with a replaced character */
    public static String replaceCharAt(String s, int pos, char c) {
        return s.substring(0,pos) + c + s.substring(pos+1);
    }

    /** returns random string from a array of strings */
    public String randomStr(String[] str,int strSize){
        r=rand.nextInt(strSize);
        return str[r];
    }

    //check if the string is still partial masked
    public boolean isMasked(String str){
        if( str.indexOf('x') == -1 ) 
            return false;
        else
            return true;
    }
public void stop()
    {
            currentSound.stop(); // stop AudioClip
         } 
          public void paint(Graphics g)
	    {
	        super.paint(g);
	        
	        g.drawImage(background,0,300,null);
	        g.drawImage(background1,650,300,null);
	        setBackground(Color.red);
	    }
}

