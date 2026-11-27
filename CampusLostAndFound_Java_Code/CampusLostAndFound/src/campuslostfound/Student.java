package campuslostfound;
import java.util.Objects;
public final class Student {
 private final StudentId id; private final String name,email;
 public Student(StudentId id,String name,String email){ this.id=Objects.requireNonNull(id); this.name=required(name,"Name"); this.email=required(email,"Email"); if(!email.contains("@")) throw new IllegalArgumentException("Invalid email"); }
 private static String required(String s,String field){ Objects.requireNonNull(s); s=s.trim(); if(s.isEmpty()) throw new IllegalArgumentException(field+" cannot be blank"); return s; }
 public StudentId id(){return id;} public String name(){return name;} public String email(){return email;}
 public boolean equals(Object o){return o instanceof Student s && id.equals(s.id);} public int hashCode(){return id.hashCode();}
 public String toString(){return name+" ["+id.value()+"]";}
}
