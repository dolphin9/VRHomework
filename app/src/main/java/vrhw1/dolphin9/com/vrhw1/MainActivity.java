package vrhw1.dolphin9.com.vrhw1;

import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import static vrhw1.dolphin9.com.vrhw1.R.attr.height;

public class MainActivity extends AppCompatActivity {

    //初始化  OpenGL
    private GLSurfaceView glSurfaceView;
    private boolean rendererSet = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //setContentView(R.layout.activity_main);

        //测试是否支持OpenGL2.0
        if(!Utils.supportGlEs20(this)){
            Toast.makeText(this,"GLES 2.0 not supported!", Toast.LENGTH_LONG).show();
            finish();
            return;
        }

        // 初始化 glSurfaceView
        glSurfaceView = new GLSurfaceView(this);

        //Configuring the Surface for OpenGL ES 2.0
        glSurfaceView.setEGLContextClientVersion(2);
        glSurfaceView.setRenderer(new MyRenderer());
        rendererSet = true;
        setContentView(glSurfaceView);
    }
    @Override
    protected void onPause(){
        super.onPause();
        if (rendererSet){
            glSurfaceView.onPause();
        }
    }
    @Override
    protected  void  onResume(){
        super.onResume();
        if(rendererSet){
            glSurfaceView.onResume();
        }
    }


    //////////////////////////////////////
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
