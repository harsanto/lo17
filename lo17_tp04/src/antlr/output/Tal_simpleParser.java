package antlr.output;
// $ANTLR 3.2 Sep 23, 2009 12:02:23 /home/jehu/Documents/git/lo17/lo17_tp04/src/antlr/Tal_simple.g 2013-11-17 01:28:36

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class Tal_simpleParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "NOM", "VERBE", "DET", "ADJ", "CONJ", "POINT", "WS"
    };
    public static final int VERBE=5;
    public static final int WS=10;
    public static final int NOM=4;
    public static final int POINT=9;
    public static final int DET=6;
    public static final int CONJ=8;
    public static final int EOF=-1;
    public static final int ADJ=7;

    // delegates
    // delegators


        public Tal_simpleParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public Tal_simpleParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return Tal_simpleParser.tokenNames; }
    public String getGrammarFileName() { return "/home/jehu/Documents/git/lo17/lo17_tp04/src/antlr/Tal_simple.g"; }



    // $ANTLR start "listephrases"
    // /home/jehu/Documents/git/lo17/lo17_tp04/src/antlr/Tal_simple.g:16:1: listephrases returns [String arbresort = \"\"] : t= phrase POINT ;
    public final String listephrases() throws RecognitionException {
        String arbresort =  "";

        Arbre t = null;


        Arbre p;
        try {
            // /home/jehu/Documents/git/lo17/lo17_tp04/src/antlr/Tal_simple.g:17:24: (t= phrase POINT )
            // /home/jehu/Documents/git/lo17/lo17_tp04/src/antlr/Tal_simple.g:18:17: t= phrase POINT
            {
            pushFollow(FOLLOW_phrase_in_listephrases142);
            t=phrase();

            state._fsp--;

            match(input,POINT,FOLLOW_POINT_in_listephrases144); 
            p = t;
                            arbresort = p.sortArbre();

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return arbresort;
    }
    // $ANTLR end "listephrases"


    // $ANTLR start "phrase"
    // /home/jehu/Documents/git/lo17/lo17_tp04/src/antlr/Tal_simple.g:23:1: phrase returns [Arbre phrase = new Arbre(\"PHRASE\")] : agnc= gn_c agva= gv ;
    public final Arbre phrase() throws RecognitionException {
        Arbre phrase =  new Arbre("PHRASE");

        Arbre agnc = null;

        Arbre agva = null;



        // on declare les variables de type arbre
        // qui sont utilises dans cette regle
                Arbre gnc, gva;
                
        try {
            // /home/jehu/Documents/git/lo17/lo17_tp04/src/antlr/Tal_simple.g:28:10: (agnc= gn_c agva= gv )
            // /home/jehu/Documents/git/lo17/lo17_tp04/src/antlr/Tal_simple.g:29:9: agnc= gn_c agva= gv
            {
            pushFollow(FOLLOW_gn_c_in_phrase198);
            agnc=gn_c();

            state._fsp--;

            pushFollow(FOLLOW_gv_in_phrase204);
            agva=gv();

            state._fsp--;


                            gnc = agnc;
                            gva = agva;
                            phrase.ajouteFils(gnc);
                            phrase.ajouteFils(gva);
                    

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return phrase;
    }
    // $ANTLR end "phrase"


    // $ANTLR start "gn_c"
    // /home/jehu/Documents/git/lo17/lo17_tp04/src/antlr/Tal_simple.g:37:1: gn_c returns [Arbre gnc = new Arbre(\"GNC\")] : agn1= gn (c= CONJ agn2= gn )* ;
    public final Arbre gn_c() throws RecognitionException {
        Arbre gnc =  new Arbre("GNC");

        Token c=null;
        Arbre agn1 = null;

        Arbre agn2 = null;


        Arbre gn1, gn2;
        try {
            // /home/jehu/Documents/git/lo17/lo17_tp04/src/antlr/Tal_simple.g:38:31: (agn1= gn (c= CONJ agn2= gn )* )
            // /home/jehu/Documents/git/lo17/lo17_tp04/src/antlr/Tal_simple.g:39:17: agn1= gn (c= CONJ agn2= gn )*
            {
            pushFollow(FOLLOW_gn_in_gn_c258);
            agn1=gn();

            state._fsp--;


                                    gn1 = agn1;
                                    gnc.ajouteFils(gn1);
                            
            // /home/jehu/Documents/git/lo17/lo17_tp04/src/antlr/Tal_simple.g:44:17: (c= CONJ agn2= gn )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==CONJ) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /home/jehu/Documents/git/lo17/lo17_tp04/src/antlr/Tal_simple.g:44:18: c= CONJ agn2= gn
            	    {
            	    c=(Token)match(input,CONJ,FOLLOW_CONJ_in_gn_c300); 
            	    pushFollow(FOLLOW_gn_in_gn_c306);
            	    agn2=gn();

            	    state._fsp--;


            	                            gnc.ajouteFils(new Arbre("CONJ",c.getText()));
            	                            gn2 =agn2;
            	                            gnc.ajouteFils(gn2);
            	                    

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return gnc;
    }
    // $ANTLR end "gn_c"


    // $ANTLR start "gn"
    // /home/jehu/Documents/git/lo17/lo17_tp04/src/antlr/Tal_simple.g:51:1: gn returns [Arbre legn = new Arbre(\"GN\")] : (d= DET n1= NOM (a= ADJ )? | n2= NOM );
    public final Arbre gn() throws RecognitionException {
        Arbre legn =  new Arbre("GN");

        Token d=null;
        Token n1=null;
        Token a=null;
        Token n2=null;

        try {
            // /home/jehu/Documents/git/lo17/lo17_tp04/src/antlr/Tal_simple.g:51:42: (d= DET n1= NOM (a= ADJ )? | n2= NOM )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==DET) ) {
                alt3=1;
            }
            else if ( (LA3_0==NOM) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // /home/jehu/Documents/git/lo17/lo17_tp04/src/antlr/Tal_simple.g:52:9: d= DET n1= NOM (a= ADJ )?
                    {
                    d=(Token)match(input,DET,FOLLOW_DET_in_gn347); 
                    n1=(Token)match(input,NOM,FOLLOW_NOM_in_gn351); 

                                    legn.ajouteFils(new Arbre("DET",d.getText()));
                                    legn.ajouteFils(new Arbre("NOM",n1.getText()));
                            
                    // /home/jehu/Documents/git/lo17/lo17_tp04/src/antlr/Tal_simple.g:57:9: (a= ADJ )?
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( (LA2_0==ADJ) ) {
                        alt2=1;
                    }
                    switch (alt2) {
                        case 1 :
                            // /home/jehu/Documents/git/lo17/lo17_tp04/src/antlr/Tal_simple.g:57:10: a= ADJ
                            {
                            a=(Token)match(input,ADJ,FOLLOW_ADJ_in_gn374); 

                                            legn.ajouteFils(new Arbre("ADJ",a.getText()));
                                    

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // /home/jehu/Documents/git/lo17/lo17_tp04/src/antlr/Tal_simple.g:61:11: n2= NOM
                    {
                    n2=(Token)match(input,NOM,FOLLOW_NOM_in_gn401); 

                                    legn.ajouteFils(new Arbre("NOM",n2.getText()));
                            

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return legn;
    }
    // $ANTLR end "gn"


    // $ANTLR start "gv"
    // /home/jehu/Documents/git/lo17/lo17_tp04/src/antlr/Tal_simple.g:67:1: gv returns [Arbre legv = new Arbre(\"GV\")] : v= VERBE (agnc= gn_c )? ;
    public final Arbre gv() throws RecognitionException {
        Arbre legv =  new Arbre("GV");

        Token v=null;
        Arbre agnc = null;


        Arbre gnc;
        try {
            // /home/jehu/Documents/git/lo17/lo17_tp04/src/antlr/Tal_simple.g:68:26: (v= VERBE (agnc= gn_c )? )
            // /home/jehu/Documents/git/lo17/lo17_tp04/src/antlr/Tal_simple.g:69:9: v= VERBE (agnc= gn_c )?
            {
            v=(Token)match(input,VERBE,FOLLOW_VERBE_in_gv445); 

                            legv.ajouteFils(new Arbre("VERBE",v.getText()));
                    
            // /home/jehu/Documents/git/lo17/lo17_tp04/src/antlr/Tal_simple.g:73:9: (agnc= gn_c )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==NOM||LA4_0==DET) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // /home/jehu/Documents/git/lo17/lo17_tp04/src/antlr/Tal_simple.g:73:10: agnc= gn_c
                    {
                    pushFollow(FOLLOW_gn_c_in_gv470);
                    agnc=gn_c();

                    state._fsp--;


                                    gnc = agnc;
                                    legv.ajouteFils(gnc);
                            

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return legv;
    }
    // $ANTLR end "gv"

    // Delegated rules


 

    public static final BitSet FOLLOW_phrase_in_listephrases142 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_POINT_in_listephrases144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_gn_c_in_phrase198 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_gv_in_phrase204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_gn_in_gn_c258 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_CONJ_in_gn_c300 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_gn_in_gn_c306 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_DET_in_gn347 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_NOM_in_gn351 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_ADJ_in_gn374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOM_in_gn401 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VERBE_in_gv445 = new BitSet(new long[]{0x0000000000000052L});
    public static final BitSet FOLLOW_gn_c_in_gv470 = new BitSet(new long[]{0x0000000000000002L});

}