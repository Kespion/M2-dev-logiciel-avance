-injars target/TP8-1.0-SNAPSHOT.jar
-outjars target/TP8-1.0-SNAPSHOT-obfuscated.jar
-libraryjars <java.home>/lib/rt.jar

-keep public class com.example.obfuscation.Main {
    public static void main(java.lang.String[]);
}
-dontoptimize