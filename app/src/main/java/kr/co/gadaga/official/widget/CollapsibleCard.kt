//package kr.co.gadaga.official.widget
//
//import android.content.Context
//import android.os.Parcel
//import android.os.Parcelable
//import android.text.method.LinkMovementMethod
//import android.transition.Transition
//import android.transition.TransitionInflater
//import android.transition.TransitionManager
//import android.util.AttributeSet
//import android.util.Log
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.FrameLayout
//import android.widget.ImageView
//import android.widget.TextView
//import androidx.core.text.HtmlCompat
//import kotlinx.android.synthetic.main.collapsible_card_content.view.*
//import kr.co.gadaga.official.R
//import org.w3c.dom.DOMImplementationSource
//import org.w3c.dom.Text
//
//class CollapsibleCard @JvmOverloads constructor(
//    context: Context,
//    attrs: AttributeSet ?= null,
//    defStyleAttr: Int = 0
//) : FrameLayout(context,attrs,defStyleAttr){
//
//    var title: String? = null
//        set(value) {
//            field = value
//            cardTitleView.text = value
//        }
//    var description: String? = null
//    var dateTime: String? = null
//    var new: String? = null
//
//    private var expanded = false
//    private val cardTitleView : TextView
//    private val cardDescriptionView : TextView
//    private val cardDatetime : TextView
//    private val cardNew : TextView
//    private val expandIcon : ImageView
//    private val titleContainer : View
//    private val toggle: Transition
//    private val root: View
//
//    init {
//        root = LayoutInflater.from(context)
//            .inflate(R.layout.collapsible_card_content, this,true)
//
//        titleContainer = root.title_container
//        cardTitleView = card_title.apply { text = title ?: "" }
//        setTitleContentDescription(title ?: "")
//
//        cardDescriptionView = card_description.apply {
//            text = description ?: ""
//            movementMethod = LinkMovementMethod.getInstance()
//        }
//
//        cardDatetime = card_date.apply{ text = dateTime ?: "" }
//
//        cardNew = card_new.apply { text = new ?: "" }
//
//        expandIcon = expand_icon
//        toggle = TransitionInflater.from(context).inflateTransition(R.transition.info_card_toggle)
//        titleContainer.setOnClickListener { toggleExpanded() }
//    }
//
//    private fun setTitleContentDescription(cardTitle: String?){
//        val res = resources
//        cardTitleView.contentDescription="$cardTitle," + if(expanded) {
//            "Expanded"
//        } else {
//            "Collapsed"
//        }
//    }
//
//    private fun toggleExpanded() {
//        expanded = !expanded
//        toggle.duration = if(expanded) 300L else 200L
//        TransitionManager.beginDelayedTransition(root.parent as ViewGroup, toggle)
//        cardDescriptionView.visibility = if(expanded) View.VISIBLE else View.GONE
//        expandIcon.rotationX = if(expanded) 180f else 0f
//        setTitleContentDescription(cardTitle)
//    }
//
//    override fun onSaveInstanceState(): Parcelable {
//        val savedState = SavedState(super.onSaveInstanceState())
//        savedState.expanded = expanded
//        return savedState
//    }
//
//    override fun onRestoreInstanceState(state: Parcelable?) {
//        if(state is SavedState) {
//            super.onRestoreInstanceState(state.superState)
//            if(expanded != state.expanded){
//                toggleExpanded()
//            }
//        } else {
//            super.onRestoreInstanceState(state)
//        }
//    }
//
//    internal class SavedState : BaseSavedState {
//        var expanded = false
//
//        constructor(source: Parcel) :super(source) {
//            expanded = source.readByte().toInt() != 0
//        }
//
//        constructor(superState:Parcelable?) : super(superState)
//
//        override fun writeToParcel(out: Parcel, flags: Int) {
//            super.writeToParcel(out, flags)
//            out.writeByte((if(expanded) 1 else 0).toByte())
//        }
//
//        companion object {
//            @JvmField
//            val CREATOR = object : Parcelable.Creator<SavedState> {
//                override fun createFromParcel(source: Parcel): SavedState {
//                    return SavedState(source)
//                }
//
//                override fun newArray(size: Int): Array<SavedState?> {
//                    return arrayOfNulls(size)
//                }
//            }
//        }
//    }
//}
//
