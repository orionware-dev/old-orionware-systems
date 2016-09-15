package gov.pnnl.aparapi.sample.mdarray;
import com.amd.aparapi.Kernel;

class DMatMul2D extends Kernel{
   double[][] A;

   double[][] B;

   double[][] C;

   int N;

   public DMatMul2D(double[][] A, double[][] B, double[][] C, int N) {
      this.A = A;
      this.B = B;
      this.C = C;
      this.N = N;
   }

   @Override public void run() {
      int id = getGlobalId();
      int i = id / N;
      int j = id % N;
      for (int k = 0; k < N; k++) {
         C[i][j] += A[i][k] * B[k][j];
      }
   }
}
