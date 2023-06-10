<#--<#assign data=text?eval />-->
<#setting number_format="#">
<#escape x as x!"">
    /**
    * sq数据通道
    */
    @AlgorDataChannel(
        source = "source://${(view.datasourceName)}"
    )
    KvChannelOnceCaller<KvChannelInput, KvChannelOutput> sqGetChannelOnceCaller;

    @Override
    public TestDataChannelOutput compute(TestDataChannelInput input, Params params, IAlgorContext context) {
        //根据数据通道的方法来构建KvChannelInput，"get"方法直接传入key字符串，"multiGet"方法传入List<String>
        KvChannelInput kvChannelInput = new KvChannelInput(key, 200);
        ListenableFuture<KvChannelOutput> future = sqGetChannelOnceCaller.futureCall(kvChannelInput,context);
        final KvChannelOutput result = future.get(200, TimeUnit.MILLISECONDS);
        if (result != null) {
        String value = result.getValue();
        logger.info("KvChannelOnceCaller: param={}, result={}", kvChannelInput, result);
        }
    }
</#escape>

