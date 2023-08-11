package com.example.taskmanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taskmanager.ui.theme.TaskManagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TaskManagerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CompleteTaskTextAndImage()

                }
            }
        }
    }
}


@Composable
fun CompleteTaskText(completeMessage: String, encouragementMessage: String) {
    // CompleteTaskText composable takes two parameters: completeMessage and
    // encouragementMessage, allowing customization of the encouragement message.
    Column {

        Text(
            text = completeMessage,
            modifier = Modifier.padding(top = 24.dp, bottom = 8.dp),
            fontWeight = FontWeight.Bold
        )

        Text(
            text = encouragementMessage,
            fontSize = 16.sp,
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
            // if you don't want to use this step here
            // then you must add
            //  horizontalAlignment = Alignment.CenterHorizontally
            // to the column
            // +
            // the reason why you need this even though you have
            // horizontalAlignment = Alignment.CenterHorizontally
            // in the column which joins the image and the text
            // is that that column consists of 2 items [image + column (text1 + text2)]
            // so horizontalAlignment = Alignment.CenterHorizontally
            // is applied to the column as a whole entity not to the separate elements
            // inside, so if the original column(text1 + text2) doesn't already
            // horizontally center the second text, the horizontalAlignment = Alignment.CenterHorizontally
            // won't do it
        )
    }

}

@Composable
fun CompleteTaskImage(
    image: Painter = painterResource(id = R.drawable.task_manager_check_mark)
) {
    Image(
        painter = image,
        contentDescription = null
    )
//  CompleteTaskImage composable that takes an image resource as a parameter,
//  allowing you to pass different images.
}


@Composable
fun CompleteTaskTextAndImage() {

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    // you didn't use .fillMaxWidth()
    //                .fillMaxHeight()
    {
        CompleteTaskImage()

        CompleteTaskText(
            completeMessage = stringResource(R.string.all_tasks_completed),
            encouragementMessage = stringResource(R.string.nice_work)
        )
    }

}

@Preview(showBackground = true)
@Composable
fun AllTasksCompletedPreview() {
    TaskManagerTheme {
        CompleteTaskTextAndImage()
    }
}


