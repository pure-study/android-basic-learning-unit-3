package me.will.courses

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.will.courses.data.DataSource
import me.will.courses.model.Topic
import me.will.courses.ui.theme.CoursesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoursesTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CoursesApp()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CoursesAppPreview() {
    CoursesTheme {
        CoursesApp()
    }
}

@Composable
fun CoursesApp(modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(4.dp),
        verticalArrangement = Arrangement.spacedBy(6.dp),
        horizontalArrangement = Arrangement.spacedBy(6.dp),
        modifier = modifier
    ) {
        items(DataSource.topics) {
            TopicCard(topic = it)
        }
    }
}

@Composable
fun TopicCard(topic: Topic, modifier: Modifier = Modifier) {
    Card(modifier = modifier) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box() {
                Image(
                    painter = painterResource(topic.topicImageId),
                    contentDescription = stringResource(topic.topicNameId),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .width(68.dp)
                        .height(68.dp)
                        .aspectRatio(1f)
                )
            }
            Column(
                modifier = Modifier.padding(10.dp)
            ) {
                Text(
                    text = LocalContext.current.getString(topic.topicNameId),
                    style = MaterialTheme.typography.bodyMedium
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_grain),
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.surfaceTint
                    )
                    Text(
                        text = topic.associatedCoursesCount.toString(),
                        style = MaterialTheme.typography.labelMedium,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
            }
        }
    }
}
