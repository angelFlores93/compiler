/* The following code was generated by JFlex 1.4.1 on 2/12/17 5:57 PM */

// =================================================================
// LAB 1. Lexical Analysis
// Simple Compiler Scanner Specification
// Angel Alberto Flores Rodríguez
// ==================================================================

package lexico;
// Following line must be commented if we wanted to do a stand alone
// Scanner. Use % standalone option too
import sintactico.Sintactico; // To communicate with Parser
// ==================================================================

/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.1
 * on 2/12/17 5:57 PM from the specification file
 * <tt>lexico/lexico.flex</tt>
 */
public class Lexico {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\24\1\2\1\0\1\24\1\23\22\0\1\24\1\41\1\6"+
    "\2\0\1\46\1\44\1\5\1\46\1\46\1\46\1\12\1\46\1\12"+
    "\1\10\1\1\12\3\1\0\1\46\1\42\1\40\1\43\2\0\4\4"+
    "\1\11\25\4\1\46\1\0\1\46\1\46\1\7\1\0\1\20\1\31"+
    "\1\32\1\27\1\16\1\17\1\35\1\33\1\25\2\4\1\21\1\36"+
    "\1\26\1\30\2\4\1\14\1\22\1\13\1\15\1\34\1\37\3\4"+
    "\1\46\1\45\1\46\uff82\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\1\1\2\1\3\1\4\1\5\1\6\1\3\1\2"+
    "\1\3\6\6\1\4\1\7\10\6\4\3\2\2\1\10"+
    "\2\0\1\6\2\0\1\11\1\1\5\6\1\12\1\13"+
    "\7\6\1\14\1\15\1\16\1\17\1\20\1\21\1\1"+
    "\1\22\1\0\1\23\5\6\1\24\1\6\1\25\5\6"+
    "\1\26\1\6\1\27\3\6\1\30\1\31\1\32\1\33"+
    "\5\6\1\34\1\35\1\36\1\37\1\40";

  private static int [] zzUnpackAction() {
    int [] result = new int[96];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\47\0\116\0\47\0\165\0\234\0\303\0\352"+
    "\0\47\0\u0111\0\u0138\0\u015f\0\u0186\0\u01ad\0\u01d4\0\u01fb"+
    "\0\47\0\u0222\0\u0249\0\u0270\0\u0297\0\u02be\0\u02e5\0\u030c"+
    "\0\u0333\0\u035a\0\u0381\0\u03a8\0\u03cf\0\u03f6\0\u041d\0\u0444"+
    "\0\u046b\0\u0492\0\u04b9\0\u04e0\0\352\0\352\0\u0507\0\u052e"+
    "\0\u0555\0\u057c\0\u05a3\0\u05ca\0\234\0\u05f1\0\u0618\0\u063f"+
    "\0\u0666\0\u068d\0\u06b4\0\u06db\0\u0702\0\47\0\47\0\47"+
    "\0\47\0\47\0\47\0\u046b\0\u0729\0\u0729\0\47\0\u0750"+
    "\0\u0777\0\u079e\0\u07c5\0\u07ec\0\234\0\u0813\0\234\0\u083a"+
    "\0\u0861\0\u0888\0\u08af\0\u08d6\0\234\0\u08fd\0\234\0\u0924"+
    "\0\u094b\0\u0972\0\234\0\234\0\234\0\234\0\u0999\0\u09c0"+
    "\0\u09e7\0\u0a0e\0\u0a35\0\234\0\234\0\234\0\234\0\234";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[96];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\2"+
    "\1\11\1\12\1\11\1\13\1\14\1\6\1\15\1\16"+
    "\2\6\1\17\1\20\1\21\1\22\1\6\1\23\1\24"+
    "\1\25\1\26\1\6\1\27\1\6\1\30\1\31\1\32"+
    "\1\33\1\34\1\35\1\36\1\37\1\11\50\0\1\40"+
    "\50\0\1\5\4\0\1\41\1\42\4\0\1\42\33\0"+
    "\2\6\2\0\1\43\1\0\1\6\1\0\10\6\2\0"+
    "\13\6\13\0\1\44\4\0\1\44\1\0\10\44\2\0"+
    "\13\44\7\0\2\45\1\0\3\45\1\46\40\45\3\0"+
    "\1\47\1\6\2\0\1\43\1\0\1\6\1\41\10\6"+
    "\2\0\13\6\12\0\2\6\2\0\1\43\1\0\1\6"+
    "\1\0\1\6\1\50\6\6\2\0\13\6\12\0\2\6"+
    "\2\0\1\43\1\0\1\6\1\0\3\6\1\51\4\6"+
    "\2\0\13\6\12\0\1\47\1\6\2\0\1\43\1\0"+
    "\1\6\1\41\6\6\1\52\1\6\2\0\13\6\12\0"+
    "\2\6\2\0\1\43\1\0\1\6\1\0\5\6\1\53"+
    "\2\6\2\0\13\6\12\0\2\6\2\0\1\43\1\0"+
    "\1\6\1\0\1\54\7\6\2\0\13\6\11\0\1\4"+
    "\47\0\2\6\2\0\1\43\1\0\1\6\1\0\4\6"+
    "\1\55\3\6\2\0\1\6\1\56\11\6\12\0\2\6"+
    "\2\0\1\43\1\0\1\6\1\0\10\6\2\0\3\6"+
    "\1\57\7\6\12\0\2\6\2\0\1\43\1\0\1\6"+
    "\1\0\2\6\1\60\5\6\2\0\13\6\12\0\2\6"+
    "\2\0\1\43\1\0\1\6\1\0\10\6\2\0\3\6"+
    "\1\61\7\6\12\0\2\6\2\0\1\43\1\0\1\6"+
    "\1\0\10\6\2\0\6\6\1\62\4\6\12\0\2\6"+
    "\2\0\1\43\1\0\1\6\1\0\10\6\2\0\3\6"+
    "\1\63\7\6\12\0\2\6\2\0\1\43\1\0\1\6"+
    "\1\0\5\6\1\64\2\6\2\0\13\6\12\0\2\6"+
    "\2\0\1\43\1\0\1\6\1\0\10\6\2\0\6\6"+
    "\1\65\4\6\47\0\1\66\46\0\1\67\46\0\1\70"+
    "\46\0\1\71\52\0\1\72\47\0\1\73\1\0\2\40"+
    "\1\0\44\40\3\0\1\74\46\0\1\75\6\0\1\76"+
    "\37\0\2\43\4\0\1\43\1\0\10\43\2\0\13\43"+
    "\14\0\1\77\44\0\1\47\1\6\2\0\1\43\1\0"+
    "\1\6\1\0\10\6\2\0\13\6\12\0\2\6\2\0"+
    "\1\43\1\0\1\6\1\0\2\6\1\100\5\6\2\0"+
    "\13\6\12\0\2\6\2\0\1\43\1\0\1\6\1\0"+
    "\1\101\7\6\2\0\13\6\12\0\2\6\2\0\1\43"+
    "\1\0\1\6\1\0\7\6\1\102\2\0\13\6\12\0"+
    "\2\6\2\0\1\43\1\0\1\6\1\0\6\6\1\103"+
    "\1\6\2\0\13\6\12\0\2\6\2\0\1\43\1\0"+
    "\1\6\1\0\1\6\1\104\6\6\2\0\13\6\12\0"+
    "\2\6\2\0\1\43\1\0\1\6\1\0\1\105\7\6"+
    "\2\0\13\6\12\0\2\6\2\0\1\43\1\0\1\6"+
    "\1\0\2\6\1\106\5\6\2\0\13\6\12\0\2\6"+
    "\2\0\1\43\1\0\1\6\1\0\1\107\7\6\2\0"+
    "\13\6\12\0\2\6\2\0\1\43\1\0\1\6\1\0"+
    "\10\6\2\0\3\6\1\110\7\6\12\0\2\6\2\0"+
    "\1\43\1\0\1\6\1\0\5\6\1\111\2\6\2\0"+
    "\13\6\12\0\2\6\2\0\1\43\1\0\1\6\1\0"+
    "\10\6\2\0\1\112\12\6\12\0\2\6\2\0\1\43"+
    "\1\0\1\6\1\0\10\6\2\0\1\113\12\6\12\0"+
    "\2\6\2\0\1\43\1\0\1\6\1\0\10\6\2\0"+
    "\1\114\12\6\12\0\1\75\46\0\2\6\2\0\1\43"+
    "\1\0\1\6\1\0\3\6\1\115\4\6\2\0\13\6"+
    "\12\0\2\6\2\0\1\43\1\0\1\6\1\0\2\6"+
    "\1\116\5\6\2\0\13\6\12\0\2\6\2\0\1\43"+
    "\1\0\1\6\1\0\3\6\1\117\4\6\2\0\13\6"+
    "\12\0\2\6\2\0\1\43\1\0\1\6\1\0\7\6"+
    "\1\100\2\0\13\6\12\0\2\6\2\0\1\43\1\0"+
    "\1\6\1\0\2\6\1\120\5\6\2\0\1\121\12\6"+
    "\12\0\2\6\2\0\1\43\1\0\1\6\1\0\10\6"+
    "\2\0\4\6\1\122\6\6\12\0\2\6\2\0\1\43"+
    "\1\0\1\6\1\0\6\6\1\123\1\6\2\0\13\6"+
    "\12\0\2\6\2\0\1\43\1\0\1\6\1\0\1\6"+
    "\1\124\6\6\2\0\13\6\12\0\2\6\2\0\1\43"+
    "\1\0\1\6\1\0\10\6\2\0\2\6\1\125\10\6"+
    "\12\0\2\6\2\0\1\43\1\0\1\6\1\0\10\6"+
    "\2\0\1\6\1\126\11\6\12\0\2\6\2\0\1\43"+
    "\1\0\1\6\1\0\6\6\1\127\1\6\2\0\13\6"+
    "\12\0\2\6\2\0\1\43\1\0\1\6\1\0\1\6"+
    "\1\130\6\6\2\0\13\6\12\0\2\6\2\0\1\43"+
    "\1\0\1\6\1\0\10\6\2\0\5\6\1\131\5\6"+
    "\12\0\2\6\2\0\1\43\1\0\1\6\1\0\10\6"+
    "\2\0\1\6\1\132\11\6\12\0\2\6\2\0\1\43"+
    "\1\0\1\6\1\0\6\6\1\133\1\6\2\0\13\6"+
    "\12\0\2\6\2\0\1\43\1\0\1\6\1\0\3\6"+
    "\1\134\4\6\2\0\13\6\12\0\2\6\2\0\1\43"+
    "\1\0\1\6\1\0\10\6\2\0\1\6\1\135\11\6"+
    "\12\0\2\6\2\0\1\43\1\0\1\6\1\0\1\136"+
    "\7\6\2\0\13\6\12\0\2\6\2\0\1\43\1\0"+
    "\1\6\1\0\10\6\2\0\10\6\1\137\2\6\12\0"+
    "\2\6\2\0\1\43\1\0\1\6\1\0\3\6\1\140"+
    "\4\6\2\0\13\6\7\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[2652];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\1\1\11\1\1\1\11\4\1\1\11\7\1\1\11"+
    "\17\1\2\0\1\1\2\0\20\1\6\11\2\1\1\0"+
    "\1\11\41\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[96];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the textposition at the last state to be included in yytext */
  private int zzPushbackPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
// ==================================================================
// Generic object for assignig a semantic value to the token
// ==================================================================
private Object yylval; // use this as Semantic value of the token
// ==================================================================
// public methods for line and column recovering. (Package protected)
// ==================================================================
public int getColumn()
{
return yycolumn+1;
}
public int getLine()
{
return yyline+1;
}
public Object getYylval()
{
return this.yylval;
}


  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public Lexico(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  public Lexico(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 128) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzPushbackPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzCurrentPos*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = zzReader.read(zzBuffer, zzEndRead,
                                            zzBuffer.length-zzEndRead);

    if (numRead < 0) {
      return true;
    }
    else {
      zzEndRead+= numRead;
      return false;
    }
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = zzPushbackPos = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public int yylex() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      for (zzCurrentPosL = zzStartRead; zzCurrentPosL < zzMarkedPosL;
                                                             zzCurrentPosL++) {
        switch (zzBufferL[zzCurrentPosL]) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn++;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = zzLexicalState;


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL[zzCurrentPosL++];
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = zzBufferL[zzCurrentPosL++];
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 23: 
          { yylval = yytext(); System.out.println("ELSE STATEMENT: " + yytext() );return Sintactico.ELSE;
          }
        case 33: break;
        case 13: 
          { yylval = yytext(); System.out.println("OPERATOR: " + yytext() );return Sintactico.NOTEQUAL;
          }
        case 34: break;
        case 19: 
          { yylval = yytext(); System.out.println("CHAR CONSTANT: " + yytext() );return Sintactico.LETTER;
          }
        case 35: break;
        case 9: 
          { yylval = yytext(); System.out.println("STRING CONSTANT: " + yytext() );return Sintactico.STRINGVALUE;
          }
        case 36: break;
        case 14: 
          { yylval = yytext(); System.out.println("OPERATOR: " + yytext() );return Sintactico.LET;
          }
        case 37: break;
        case 26: 
          { yylval = yytext();System.out.println("VOID TYPE: " + yytext() ); return Sintactico.VOID;
          }
        case 38: break;
        case 1: 
          { yylval = new Double(yytext()); System.out.println("DOUBLE CONSTANT:" + yytext() );return Sintactico.REAL;
          }
        case 39: break;
        case 32: 
          { yylval = yytext(); System.out.println("DOUBLE TYPE: " + yytext() );return Sintactico.DOUBLE;
          }
        case 40: break;
        case 21: 
          { yylval = yytext();System.out.println("RESERVED WORD: " + yytext() ); return Sintactico.PRINT;
          }
        case 41: break;
        case 29: 
          { yylval = yytext(); System.out.println("RESERVED WORD: " + yytext() );return Sintactico.RETURN;
          }
        case 42: break;
        case 31: 
          { yylval = yytext();System.out.println("STRING TYPE: " + yytext() ); return Sintactico.STRING;
          }
        case 43: break;
        case 5: 
          { yylval = new Integer(yytext()); System.out.println("INTEGER CONSTANT: " + yytext() );return Sintactico.INTEGER;
          }
        case 44: break;
        case 15: 
          { yylval = yytext(); System.out.println("OPERATOR: " + yytext() );return Sintactico.GET;
          }
        case 45: break;
        case 17: 
          { yylval = yytext(); System.out.println("OPERATOR: " + yytext() );return Sintactico.OR;
          }
        case 46: break;
        case 18: 
          { yylval = new Double(yytext()); System.out.println("DIGIGT CONSTANT: " + yytext() );return Sintactico.REAL;
          }
        case 47: break;
        case 12: 
          { yylval = yytext(); System.out.println("OPERATOR: " + yytext() );return Sintactico.EQUAL;
          }
        case 48: break;
        case 2: 
          { System.err.println ("Scanner Error at Line: "
+ this.getLine() +
" Column: "+getColumn()+":\n\tCharacter \'"+
yycharat(0)+"\' unknown.");
System.err.println("yytext value: " + yytext());
          }
        case 49: break;
        case 3: 
          { yylval = yytext(); System.out.println("OPERATOR: " + yytext() ); return (int) (yycharat(0));
          }
        case 50: break;
        case 24: 
          { yylval = yytext(); System.out.println("BOOLEAN TYPE: " + yytext() );return Sintactico.BOOL;
          }
        case 51: break;
        case 28: 
          { yylval = yytext(); System.out.println("WHILE STATEMENT: " + yytext() );return Sintactico.WHILE;
          }
        case 52: break;
        case 10: 
          { yylval = yytext(); System.out.println("IF STATEMENT: " + yytext() );return Sintactico.IF;
          }
        case 53: break;
        case 8: 
          { System.out.println("COMMENT: " + yytext() );
          }
        case 54: break;
        case 11: 
          { yylval = yytext(); System.out.println("RESERVED WORD: " + yytext() );return Sintactico.INPUT;
          }
        case 55: break;
        case 27: 
          { yylval = yytext(); System.out.println("RESERVED WORD: " + yytext() ); return Sintactico.MAIN;
          }
        case 56: break;
        case 6: 
          { yylval = yytext(); System.out.println("IDENTIFIER: " + yytext() );return Sintactico.ID;
          }
        case 57: break;
        case 20: 
          { yylval = yytext(); System.out.println("INT TYPE: " + yytext() );return Sintactico.INT;
          }
        case 58: break;
        case 7: 
          { System.out.println("NULLTEXT: " + yytext() );
          }
        case 59: break;
        case 22: 
          { yylval = new Boolean(yytext()); System.out.println("BOOLEAN CONSTANT: " + yytext() );return Sintactico.BOOLEAN;
          }
        case 60: break;
        case 25: 
          { yylval = yytext(); System.out.println("CHAR TYPE: " + yytext() );return Sintactico.CHAR;
          }
        case 61: break;
        case 30: 
          { yylval = yytext();System.out.println("STRUCT TYPE: " + yytext() ); return Sintactico.STRUCT;
          }
        case 62: break;
        case 4: 
          { 
          }
        case 63: break;
        case 16: 
          { yylval = yytext(); System.out.println("OPERATOR: " + yytext() );return Sintactico.AND;
          }
        case 64: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            zzDoEOF();
              { return 0; }
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }

  /**
   * Runs the scanner on input files.
   *
   * This is a standalone scanner, it will print any unmatched
   * text to System.out unchanged.
   *
   * @param argv   the command line, contains the filenames to run
   *               the scanner on.
   */
  public static void main(String argv[]) {
    if (argv.length == 0) {
      System.out.println("Usage : java Lexico <inputfile>");
    }
    else {
      for (int i = 0; i < argv.length; i++) {
        Lexico scanner = null;
        try {
          scanner = new Lexico( new java.io.FileReader(argv[i]) );
          while ( !scanner.zzAtEOF ) scanner.yylex();
        }
        catch (java.io.FileNotFoundException e) {
          System.out.println("File not found : \""+argv[i]+"\"");
        }
        catch (java.io.IOException e) {
          System.out.println("IO error scanning file \""+argv[i]+"\"");
          System.out.println(e);
        }
        catch (Exception e) {
          System.out.println("Unexpected exception:");
          e.printStackTrace();
        }
      }
    }
  }


}
