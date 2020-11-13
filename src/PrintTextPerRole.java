import org.junit.Assert;
import org.junit.Test;

public class PrintTextPerRole {
    String[] roles = {
            "Городничий", "Аммос Федорович",
            "Артемий Филиппович",
            "Лука Лукич"};
    String[] textLines = {
            "Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.",
            "Аммос Федорович: Как ревизор?",
            "Артемий Филиппович: Как ревизор?",
            "Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.",
            "Аммос Федорович: Вот те на!",
            "Артемий Филиппович: Вот не было заботы, так подай!",
            "Лука Лукич: Господи боже! еще и с секретным предписаньем!"
    };


    public String getReplica(int index, String text) {
        return index + ") " + text + "\n";
    }

    public boolean textLineBelongRole(String role, String textLine){
        StringBuilder textLineBuffer = new StringBuilder(textLine);
        int index = textLineBuffer.indexOf(role+": ");
        return index == 0;
    }

    public String getTextLineWithoutRole(String role, String textLine){
        StringBuilder textLineBuffer = new StringBuilder(textLine);
        return textLineBuffer.substring(role.length() + 2);
    }

    public String getRoleWithReplicas(String role, String[] textLines) {
        StringBuilder roleWithReplica = new StringBuilder(role);
        roleWithReplica.append(":\n");

        for (int i = 0; i < textLines.length; i+=1) {
            String textLine = textLines[i];
            if (textLineBelongRole(role, textLine)) {
                roleWithReplica.append(
                    getReplica(i + 1, getTextLineWithoutRole(role, textLine))
                );
            }
        }
        return roleWithReplica.toString();
    }

    public String printTextPerRole(String[] roles, String[] textLines) {
        StringBuilder result = new StringBuilder("");
        for (int i = 0; i < roles.length; i += 1) {
            String role = roles[i];
            System.out.println(role);
            result.append(getRoleWithReplicas(role, textLines));
            if(i < roles.length - 1){
                result.append("\n");
            }
        }

        return result.toString();
    }

    @Test
    public void testGetReplica() {
        PrintTextPerRole inst = new PrintTextPerRole();
        Assert.assertEquals("1) Я пригласил вас\n", inst.getReplica(1, "Я пригласил вас"));
    }
    @Test
    public void testTextLineBelongRole() {
        PrintTextPerRole inst = new PrintTextPerRole();
        Assert.assertEquals(true, inst.textLineBelongRole("Городничий", "Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор."));
        Assert.assertEquals(false, inst.textLineBelongRole("Лука Лукич", "Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор."));
    }
    @Test
    public void testGetTextLineWithoutRole() {
        PrintTextPerRole inst = new PrintTextPerRole();
        Assert.assertEquals("Я пригласил вас.", inst.getTextLineWithoutRole("Городничий", "Городничий: Я пригласил вас."));
    }
    @Test
    public void testGetRoleWithReplicas() {
        PrintTextPerRole inst = new PrintTextPerRole();
        Assert.assertEquals("Городничий:\n" +
                "1) Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.\n" +
                "4) Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.\n", inst.getRoleWithReplicas("Городничий", textLines));
    }

    @Test
    public void testPrintTextPerRole() {


        PrintTextPerRole inst = new PrintTextPerRole();

        Assert.assertEquals("Городничий:\n" +
                "1) Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.\n" +
                "4) Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.\n" +
                "\n" +
                "Аммос Федорович:\n" +
                "2) Как ревизор?\n" +
                "5) Вот те на!\n" +
                "\n" +
                "Артемий Филиппович:\n" +
                "3) Как ревизор?\n" +
                "6) Вот не было заботы, так подай!\n" +
                "\n" +
                "Лука Лукич:\n" +
                "7) Господи боже! еще и с секретным предписаньем!\n", inst.printTextPerRole(roles, textLines));

    }

}
