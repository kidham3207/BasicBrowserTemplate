package edu.temple.basicbrowser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.EditText
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {

    private lateinit var urlEditText: EditText
    private lateinit var goButton: ImageButton
    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        urlEditText = findViewById(R.id.urlEditText)
        goButton = findViewById(R.id.goButton)
        webView = findViewById(R.id.webView)





        webView.webViewClient = object: WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)




        // Allow your browser to intercept hyperlink clicks


//                if(url != null) {
//                    var n = 5
//                    if(url.take(n) != "https" && url.take(n-1) != "http") {
//                        var newUrl = checkInput(url)
//                        webView.loadUrl(newUrl)
//                        urlEditText.text = newUrl
//                    }
//
//                }





            }
        }

        goButton.setOnClickListener {
            var url = urlEditText.text.toString()
            var newUrl = fixUrl(url)
            //webView.loadUrl(url)
//            if( url.startsWith("https://")){
//
//                webView.loadUrl(url)
//            }
//            else{
//                urlEditText.setText("https://$url")
//                webView.loadUrl(("https://$url"))
//            }
            webView.loadUrl(newUrl)
            urlEditText.setText(newUrl)


        }


    }

    fun fixUrl(url : String) : String{
        if(url.startsWith("http")){
            return url
        }
        else{
            return "https://$url"
        }
    }
//
//    fun checkInput(url : String) : String{
//        if(url.take(5) != "https") {
//            return "https://" + url
//        }
//        return url
//    }

}
