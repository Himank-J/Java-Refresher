package Collection_Generics;

class StringConcat {

    public static void main(String[] args) {
        String finalStr = multiconcat("Himank", "Jain");
        System.out.println(finalStr);
    }

    public static String multiconcat(String... elements){
        String finalStr = "";
        for (String element: elements){
            finalStr += element + " ";
        }
        return finalStr.strip();
    }
}