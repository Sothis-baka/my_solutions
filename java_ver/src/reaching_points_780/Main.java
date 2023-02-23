package reaching_points_780;

public class Main {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        /*
           Do it reversely.
           We can only use larger value to subtract smaller value.

           case 1: tx > ty, tx = tx - ty, ty = ty
           case 2: tx < ty, tx = tx, ty = ty - tx
           case 3: tx == ty, tx = tx - ty, ty = ty
                           or tx = tx, ty = ty - tx

           Use mod to accelerate the process, because if x - y > y, we need to continue with x - 2y, x - 3y, x - 4y, ...
         */
        if(sx == tx && sy == ty) return true;
        if(sx > tx || sy > ty) return false;

        if(tx > ty) {
            int newTx = (tx - sx) % ty + sx;
            return newTx == tx
                    ? reachingPoints(sx, sy, tx - ty, ty)   // It can only be reduced once
                    : reachingPoints(sx, sy, newTx, ty);    // Reduce as much as possible
        }
        else if(tx < ty) {
            int newTy = (ty - sy) % tx + sy;
            return newTy == ty
                    ? reachingPoints(sx, sy, tx, ty - tx)   // It can only be reduced once
                    : reachingPoints(sx, sy, tx, newTy);    // Reduce as much as possible
        }
        else return reachingPoints(sx, sy, 0, ty) || reachingPoints(sx, sy, tx, 0);
    }
}
