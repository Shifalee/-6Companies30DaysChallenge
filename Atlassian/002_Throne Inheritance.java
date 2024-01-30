import java.util.*;
class ThroneInheritance {

    public ThroneInheritance(String kingName) {
        this.kingName=kingName;
        
    }
    
    public void birth(String parentName, String childName) {
        family.putIfAbsent(parentName,new ArrayList<>());
        family.get(parentName).add(childName);
        
    }
    
    public void death(String name) {
        dead.add(name);
    }
    
    public List<String> getInheritanceOrder() {
        List<String> ans=new ArrayList<>();
        dfs(kingName,ans);
        return ans;
    }
    private Set<String> dead=new HashSet<>();
    private Map<String,List<String>> family=new HashMap<>();
    private String kingName;
    private void dfs(final String name,List<String> ans){
        if(!dead.contains(name))
        ans.add(name);
        if(!family.containsKey(name))
        return;
        for(final String child:family.get(name))
        dfs(child,ans);
    }
}

/**
 * Your ThroneInheritance object will be instantiated and called as such:
 * ThroneInheritance obj = new ThroneInheritance(kingName);
 * obj.birth(parentName,childName);
 * obj.death(name);
 * List<String> param_3 = obj.getInheritanceOrder();
 */