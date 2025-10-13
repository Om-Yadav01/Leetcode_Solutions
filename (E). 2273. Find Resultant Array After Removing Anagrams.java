class Solution {
    public List<String> removeAnagrams(String[] words) {
        int n=words.length;
        String[] ana=new String[n];
        for(int i=0;i<n;i++){
            char[] ch=words[i].toCharArray();
            Arrays.sort(ch);
            ana[i]=new String(ch);

        }
        List<String> yu=new ArrayList<>();
yu.add(words[0]);
        for(int j=1;j<n;j++){if(!ana[j].equals(ana[j-1])){
            yu.add(words[j]);
        }

        }
        return yu;

    }
}
