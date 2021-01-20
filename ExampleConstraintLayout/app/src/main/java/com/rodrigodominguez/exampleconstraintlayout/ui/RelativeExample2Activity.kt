package com.rodrigodominguez.exampleconstraintlayout.ui

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.FrameMetrics
import androidx.annotation.RequiresApi
import com.rodrigodominguez.exampleconstraintlayout.R

class RelativeExample2Activity : AppCompatActivity() {
    lateinit var metrics: FrameMetrics

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_relative_example2)
        val handler = Handler()
        window.addOnFrameMetricsAvailableListener({ window, frameMetrics, i ->
            metrics = FrameMetrics(frameMetrics)
        }, handler)

        handler.postDelayed({
            Log.d(
                "Metrics",
                "ANIMATION_DURATION: " + metrics.getMetric(FrameMetrics.ANIMATION_DURATION) / Math.pow(
                    10.0,
                    6.0
                )
            )
            Log.d(
                "Metrics",
                "COMMAND_ISSUE_DURATION: " + metrics.getMetric(FrameMetrics.COMMAND_ISSUE_DURATION) / Math.pow(
                    10.0,
                    6.0
                )
            )
            Log.d(
                "Metrics",
                "DRAW_DURATION: " + metrics.getMetric(FrameMetrics.DRAW_DURATION) / Math.pow(
                    10.0,
                    6.0
                )
            )
            Log.d(
                "Metrics",
                "FIRST_DRAW_FRAME: " + metrics.getMetric(FrameMetrics.FIRST_DRAW_FRAME) / Math.pow(
                    10.0,
                    6.0
                )
            )
            Log.d(
                "Metrics",
                "INPUT_HANDLING_DURATION: " + metrics.getMetric(FrameMetrics.INPUT_HANDLING_DURATION) / Math.pow(
                    10.0,
                    6.0
                )
            )
            Log.d(
                "Metrics",
                "LAYOUT_MEASURE_DURATION: " + metrics.getMetric(FrameMetrics.LAYOUT_MEASURE_DURATION) / Math.pow(
                    10.0,
                    6.0
                )
            )
            Log.d(
                "Metrics",
                "SWAP_BUFFERS_DURATION: " + metrics.getMetric(FrameMetrics.SWAP_BUFFERS_DURATION) / Math.pow(
                    10.0,
                    6.0
                )
            )
            Log.d(
                "Metrics",
                "SYNC_DURATION: " + metrics.getMetric(FrameMetrics.SYNC_DURATION) / Math.pow(
                    10.0,
                    6.0
                )
            )
            Log.d(
                "Metrics",
                "TOTAL_DURATION: " + metrics.getMetric(FrameMetrics.TOTAL_DURATION) / Math.pow(
                    10.0,
                    6.0
                )
            )
            Log.d(
                "Metrics",
                "UNKNOWN_DELAY_DURATION: " + metrics.getMetric(FrameMetrics.UNKNOWN_DELAY_DURATION) / Math.pow(
                    10.0,
                    6.0
                )
            )
        }, 2000)
    }
}