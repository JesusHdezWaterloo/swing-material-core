package com.jhw.swing.bundles.loading;

import java.util.concurrent.ExecutionException;
import javax.swing.SwingWorker;

/**
 * Clase para ejecutar tareas en segundo plano con un cartel de cargando en
 * espera a que termine. <\br>
 * NOTA: NO INCLUYE: <\br>
 * - Timeout. <\br>
 * - Progreso. <\br>
 * - Timeout. <\br>
 *
 * Ejemplo de como se usa. <\br>
 *
 * <pre>
 *  new LoadingWorker{@code <Integer>}(new LoadingProcess{@code <Integer>}() {
 *     {@code @Override}
 *      public Integer process() throws Exception {
 *          Thread.sleep(3 * 1000);
 *          return 5;
 *      }
 *
 *     {@code @Override}
 *      public void completed(Integer result) throws Exception {
 *          System.out.println(result);
 *          throw new Exception("Errro en el completed");
 *      }
 *
 *     {@code @Override}
 *      public void errorInProcess(Exception result) {
 *          System.out.println(result);
 *      }
 *  });
 *
 * </pre>
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 * @param <T> Tipo de dato del return del doInBackground();
 */
public class LoadingWorker<T> extends SwingWorker<T, Void> {

    private LoadingDialog dialogLoading;
    private final LoadingProcess<T> process;
    private Exception exception;

    public LoadingWorker(LoadingProcess p) {
        dialogLoading = new LoadingDialog();
        this.process = p;
        this.execute();
    }

    @Override
    protected T doInBackground() throws Exception {
        try {
            return process.process();
        } catch (Exception e) {
            this.exception = e;
        }
        return null;
    }

    @Override
    protected void done() {
        try {
            dialogLoading.dispose();
            dialogLoading = null;
            if (exception != null) {//se lanzo excepcion
                process.errorInProcess(exception);
            } else {//todo ok
                process.completed(this.get());
            }
        } catch (Exception ex) {
            process.errorInProcess(ex);
        }
        super.done();
    }

}