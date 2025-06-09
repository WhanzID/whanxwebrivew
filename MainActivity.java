
package com.whanx.lockedweb;

import android.app.AlertDialog;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.view.KeyEvent;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    WebView webView;
    private final String password = "089809812";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        webView = new WebView(this);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://whanx.my.id");
        webView.setWebViewClient(new WebViewClient());
        setContentView(webView);
    }

    @Override
    public void onBackPressed() {
        // Do nothing
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_VOLUME_DOWN) {
            showPasswordDialog();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void showPasswordDialog() {
        final EditText input = new EditText(this);
        new AlertDialog.Builder(this)
            .setTitle("Masukkan Password")
            .setView(input)
            .setPositiveButton("OK", (dialog, whichButton) -> {
                if (input.getText().toString().equals(password)) {
                    finish();
                }
            })
            .setNegativeButton("Batal", null)
            .show();
    }
}
