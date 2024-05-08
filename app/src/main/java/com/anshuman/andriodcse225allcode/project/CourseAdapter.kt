import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.TextView
import com.anshuman.andriodcse225allcode.R
import com.anshuman.andriodcse225allcode.project.Course

// CourseAdapter.kt
class CourseAdapter(context: Context, private val courses: List<Course>) : BaseAdapter() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)

    override fun getCount(): Int = courses.size

    override fun getItem(position: Int): Any = courses[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: inflater.inflate(R.layout.list_item, parent, false)
        val course = courses[position]

        val textCourseName = view.findViewById<TextView>(R.id.text_course_name)
        val btnRegister = view.findViewById<Button>(R.id.btn_register)

        textCourseName.text = course.name

        btnRegister.setOnClickListener {
            // Handle button click to register for the course
            // Implement implicit intent to connect to registration page
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://www.geeksforgeeks.org/courses/${course.name}")
            view.context.startActivity(intent)
        }

        return view
    }
}
