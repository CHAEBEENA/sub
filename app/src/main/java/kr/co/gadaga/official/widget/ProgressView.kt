package kr.co.gadaga.official.widget

import android.content.Context
import android.graphics.PorterDuff
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.card.MaterialCardView
import kr.co.gadaga.official.R

class ProgressView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : MaterialCardView(context, attrs, defStyleAttr) {

    init {
        val arr = context.obtainStyledAttributes(attrs, R.styleable.ProgressView, defStyleAttr, R.style.Widget_Gadaga_ProgressView)
        val progressColorValue = arr.getColor(R.styleable.ProgressView_indicator_color, 0)
        val progressDescription = arr.getString(R.styleable.ProgressView_description)
        arr.recycle()

        LayoutInflater.from(context).inflate(R.layout.widget_progress_content, this, true)

        findViewById<ImageView>(R.id.progressImage).apply {
            /* TODO tint 적용 안됨 */
            if(progressColorValue != 0) {
                setColorFilter(progressColorValue, PorterDuff.Mode.SRC_OVER)
            }
        }

        findViewById<TextView>(R.id.progressDescription).apply {
            text = progressDescription
        }
    }
}