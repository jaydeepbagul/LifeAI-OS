package com.lifeai.os;

import android.os.Bundle;
import android.webkit.WebView;
import com.getcapacitor.BridgeActivity;
import com.getcapacitor.WebViewListener;

public class MainActivity extends BridgeActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getBridge().addWebViewListener(new WebViewListener() {
            @Override
            public void onPageStarted(WebView webView) {
                injectApperBlocker(webView);
            }

            @Override
            public void onPageLoaded(WebView webView) {
                injectApperBlocker(webView);
            }

            @Override
            public void onPageCommitVisible(WebView webView, String url) {
                injectApperBlocker(webView);
            }
        });
    }

    private void injectApperBlocker(WebView webView) {
        if (webView == null) return;

        // Block Apper branding badge via CSS, DOM removal, MutationObserver, and script neutralizer
        final String js = "(function() {"
                + "  try {"
                + "    var style = document.getElementById('lifeai-anti-apper-style');"
                + "    if (!style) {"
                + "      style = document.createElement('style');"
                + "      style.id = 'lifeai-anti-apper-style';"
                + "      style.innerHTML = '#apper-branding, #apper_branding_container, .apper_branding, #apper-made-with-anchor, #apper-clone-edit-anchor, [id*=\"apper_branding\"], [id*=\"apper-branding\"], [class*=\"apper_branding\"] { display: none !important; opacity: 0 !important; visibility: hidden !important; pointer-events: none !important; width: 0 !important; height: 0 !important; overflow: hidden !important; position: absolute !important; left: -99999px !important; bottom: -99999px !important; }';"
                + "      (document.head || document.documentElement).appendChild(style);"
                + "    }"
                + "    window.ApperCloneApp = { start: function() {}, isClonable: function() { return false; } };"
                + "    var ids = ['apper-branding', 'apper_branding_container'];"
                + "    for (var i = 0; i < ids.length; i++) {"
                + "      var el = document.getElementById(ids[i]);"
                + "      if (el && el.parentNode) { el.parentNode.removeChild(el); }"
                + "    }"
                + "    var els = document.querySelectorAll('.apper_branding, #apper-made-with-anchor, [id*=\"apper-branding\"]');"
                + "    for (var j = 0; j < els.length; j++) {"
                + "      if (els[j] && els[j].parentNode) { els[j].parentNode.removeChild(els[j]); }"
                + "    }"
                + "    if (!window.__lifeaiObserver && window.MutationObserver) {"
                + "      window.__lifeaiObserver = true;"
                + "      var obs = new MutationObserver(function() {"
                + "        var b = document.getElementById('apper-branding') || document.getElementById('apper_branding_container') || document.querySelector('.apper_branding');"
                + "        if (b && b.parentNode) { b.parentNode.removeChild(b); }"
                + "      });"
                + "      obs.observe(document.documentElement, { childList: true, subtree: true });"
                + "    }"
                + "  } catch (e) {}"
                + "})();";

        webView.post(new Runnable() {
            @Override
            public void run() {
                webView.evaluateJavascript(js, null);
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (getBridge() != null && getBridge().getWebView() != null && getBridge().getWebView().canGoBack()) {
            getBridge().getWebView().goBack();
        } else {
            super.onBackPressed();
        }
    }
}
