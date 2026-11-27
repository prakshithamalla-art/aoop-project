package campuslostfound;
import java.util.Objects;
public record ItemDescription(String name, String details, ItemCategory category) {
 public ItemDescription { Objects.requireNonNull(name); Objects.requireNonNull(details); Objects.requireNonNull(category); name=name.trim(); details=details.trim(); if(name.isEmpty()||details.isEmpty()) throw new IllegalArgumentException("Name and details are required"); }
 public String toString(){ return name+" ("+category+"): "+details; }
}
