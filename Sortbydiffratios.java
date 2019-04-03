import java.util.*;

class Sortbydiffratios implements Comparator<Model> 
{ 
    // Used for sorting in descendin order of 
    // diff ratios
    public int compare(Model a, Model b) 
    { 
        return Double.compare(a.getDiffRatios(), b.getDiffRatios()); 
    } 
} 