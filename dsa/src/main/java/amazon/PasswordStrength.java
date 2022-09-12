package amazon;

public class PasswordStrength {
    public static void main(String[] args) {

        int strenght = 0;

        String vowels = "aeoiu";
        String password = "hackerrank";
        char[] pass = password.toCharArray();
        boolean vowelC = false, consonantsC= false;

        for (int i = 0; i < pass.length ; i++) {

            if (vowels.indexOf(pass[i]) != -1) {

                vowelC = true;

            } else {
                consonantsC = true;
            }

            if (vowelC && consonantsC) {

                strenght++;
                vowelC = consonantsC= false;

            }

        }

        System.out.println(strenght);
    }
}

