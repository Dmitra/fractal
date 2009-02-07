module Kernel
  def run(&block)
    instance_eval(&block)
  end
end

class User
  def input
      puts "input"    
  end  
  def out
      puts "out"      
  end
  def do(*methods)
      methods.each do |i| self.send i end
  end  
  def exe
    p yield.class
  end
end

dmitra = User.new

#dmitra.do(
#  :input,
#  :out
#)

dmitra.run{
  input
  out
}
