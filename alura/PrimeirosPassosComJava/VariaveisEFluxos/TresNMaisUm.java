class TresNMaisUm {
    public static void main(String[] args) {
        int x = 19;
        System.out.print("Iniciando... " + x);
        while (x != 1) {
        System.out.print(" > ");
            if (x % 2 == 0) {
                x = x / 2;
            } else {
                x = 3 * x + 1;
            }
            System.out.print(x);
        }
    }
}