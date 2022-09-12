package tree;

import java.util.*;

public class AccountsMerge
{
    HashMap<String, ArrayList<String>> map = new HashMap<>();
    HashSet<String> visited = new HashSet<>();
    public static void main(String [] args){
        AccountsMerge accounts=new AccountsMerge();
        List<List<String>> listOfAccounts = new ArrayList<>();
        listOfAccounts.add(Arrays.asList(new String[]{"John","johnsmith@mail.com","john_newyork@mail.com"}));
        listOfAccounts.add(Arrays.asList(new String[]{"John","johnsmith@mail.com","john00@mail.com"}));
        listOfAccounts.add(Arrays.asList(new String[]{"Mary","mary@mail.com"}));
        listOfAccounts.add(Arrays.asList(new String[]{"John","johnnybravo@mail.com"}));
        List<List<String>> ans =accounts.accountsMerge(listOfAccounts);
        for(List<String> l: ans){
            for(String s:l){
                System.out.println((s));
            }
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts)
    {
        for (List<String> current : accounts)
        {
            int size = current.size();
            String name = current.get(0);
            String first_email = current.get(1);
            if (!map.containsKey(first_email))
                map.put(first_email, new ArrayList<>());
            for (int i = 2; i < size; i++)
            {
                map.get(first_email).add(current.get(i));
                if (map.containsKey(current.get(i)))
                {
                    map.get(current.get(i)).add(first_email);
                }
                else
                {
                    map.put(current.get(i), new ArrayList<>());
                    map.get(current.get(i)).add(first_email);
                }
            }
        }
        List<List<String>> result = new ArrayList<>();
        for (List<String> current : accounts)
        {
            int size = current.size();
            String name = current.get(0);
            String first_email = current.get(1);
            if (!visited.contains(first_email))
            {
                ArrayList<String> temp = new ArrayList<>();
                visited.add(first_email);
                temp.add(first_email);
                dfs(first_email, temp);
                Collections.sort(temp);
                temp.add(0, name);
                result.add(temp);
            }
        }
        return result;
    }

    void dfs(String node, ArrayList<String> list)
    {
        for (String temp : map.get(node))
        {
            if (!visited.contains(temp))
            {
                visited.add(temp);
                list.add(temp);
                dfs(temp, list);
            }
        }
    }
}
