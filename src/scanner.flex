%%
%public
%class SimpleLexer
%unicode
%cup

// Definir patrones para nombres de animales
ANIMAL = ("perro"|"gato"|"elefante"|"tigre"|"leon"|"oso"|"serpiente"|"jirafa"|"pinguino"|"delfin")
WORD = [a-zA-Z]+
WHITESPACE = [ \t\r\n]+

%%
{ANIMAL}         { return new java_cup.runtime.Symbol(Token.ANIMAL, yytext()); }  // Retorna el nombre del animal
{WHITESPACE}     { /* Ignorar espacios en blanco */ }
{WORD}           { return new java_cup.runtime.Symbol(Token.OTRO, yytext()); }    // Retorna cualquier otra palabra
.                { /* Ignorar cualquier otro carácter no reconocido */ }
