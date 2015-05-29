/*
 * Copyright (c) 2015, jie
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * * Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 * * Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package tw.edu.npu.mis;

/**
 * 將View的各項設置完成
 * 而把onDraw的部分設置為abstract
 * 使View可以藉由繼承而達到多種呈現效果
 * @author jie
 */
public abstract class AbstractView implements Observer
{
    
    protected final String mName;
    protected final Window mWindow;
    protected final Model mModel;
    
    /**
     * 
     * @param name 設置這個View的名稱。
     * @param window 設定這個View在哪個Window裡。
     * @param model 設定View所讀取的Model。
     */
    public AbstractView(String name, Window window, Model model) {
        mName = name;
        mWindow = window;
        mModel = model;
        mModel.Attach(this);
    }

    /**
     * 將View加入到重繪佇列中
     */
    public void invalidate() {
        mWindow.schduleRedraw(this);
    }

    /**
     * 印出資料，為了可以使onDraw有多種呈現，所以這邊暫時不實作，將由繼承這個他的物件實作。
     */
    public abstract void onDraw();
    
    /**
     * 複寫Observer中的Update()，去實作他。
     */
    @Override
    public void Update() {
        invalidate();
    }

    
}
