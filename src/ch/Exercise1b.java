class Exercise1b {
    public static void main(String [] args) {
        int x = 1;
        while ( x < 10 ) {
            //to break from deadlock
            System.out.print(".");
            ++x;
            if ( x > 3 ) {
                System.out.println("big x");
                //to break from deadlock
                break;
            }
        }
        switch(x)
        {
            case 1:System.out.println("nope" + x);break;
            case 2:System.out.println("nope" + x);break;
            case 3:System.out.println("nope" + x);break;
            default: System.out.println(" " + x);System.exit(1);//;break;
        }
    }

}