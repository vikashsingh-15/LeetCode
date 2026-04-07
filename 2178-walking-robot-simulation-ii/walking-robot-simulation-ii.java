/// way 1
class Robot {

    int width, height;
    int pos = 0;
    int perimeter;
    boolean moved = false;

    public Robot(int width, int height) {
        this.width = width;
        this.height = height;
        this.perimeter = 2 * (width + height) - 4;
    }

    public void step(int num) {
        moved = true;
        pos = (pos + num) % perimeter;
    }

    public int[] getPos() {

        int p = pos;

        if (p <= width - 1) {
            return new int[] { p, 0 };
        }

        p -= (width - 1);

        if (p <= height - 1) {
            return new int[] { width - 1, p };
        }

        p -= (height - 1);

        if (p <= width - 1) {
            return new int[] { width - 1 - p, height - 1 };
        }

        p -= (width - 1);

        return new int[] { 0, height - 1 - p };
    }

    public String getDir() {

        if (!moved)
            return "East";

        if (pos == 0)
            return "South";

        int bottom = width - 1;
        int right = height - 1;
        int top = width - 1;

        if (pos <= width-1)
            return "East";

        if (pos <= bottom + right)
            return "North";

        if (pos <= bottom + right + top)
            return "West";


        return "South";
    }
}