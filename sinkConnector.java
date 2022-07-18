jobName: sinkConnector
jobConfigClientProperties: !<DynamicBucketClientProperties>
  bucketName: FStream-Job.Stage
executionEngineConfig: !<FlinkExecutionEngine>
  executionClassName: com.flipkart.fstream.processor.executionengine.FlinkExecutionEngine
  flinkConfPoolName: FStreamFlinkIntegrationTest
operatorConfigs:
  sourceId: !<SourceOperatorConfig>
    executionClassName: com.flipkart.fdsg.fstream.source.flink.FlinkFStreamKafkaImpl
    config: !<FlinkKafkaSourceConfig>
      infraConfig: !<KafkaInfraConfig>
        poolName: FStreamStageKafka
      taskConfig: !<FlinkKafkaSourceTaskConfig>
        topics:
          - source-kafka-bigquery--test
        flinkConfPoolName: FStreamFlinkIntegrationTest
        taskName: SampleIntegrationTestTask
      checkpointConfigPoolName: FStreamStageHbase
  bigquerySink: !<SinkOperatorConfig>
    executionClassName: com.flipkart.fdsg.fstream.sinks.bigquery.BigQuerySink
    config: !<BigQuerySinkConfig>
      infraConfig: !<BigQueryInfraConfig>
        poolName: FStreamStageBigQuery
      taskConfig: !<BigQuerySinkTaskConfig>
        datasetName: basketball
        tableName: Test
