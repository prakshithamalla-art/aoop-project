package campuslostfound;
import java.util.Objects;
public final class Admin {
 private final AdminId id; private final String name;
 public Admin(AdminId id,String name){this.id=Objects.requireNonNull(id); Objects.requireNonNull(name); this.name=name.trim(); if(this.name.isEmpty()) throw new IllegalArgumentException("Admin name required");}
 public AdminId id(){return id;} public String name(){return name;}
}
