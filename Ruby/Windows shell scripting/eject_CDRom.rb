class CdRom

    attr_accessor :drive, :drive_letter, :verbs

    def initialize(drive_letter)
        my_computer = 17
        @drive_letter = drive_letter
        sh = WIN32OLE.new("Shell.Application")
        @drive= sh.NameSpace(my_computer).ParseName("#{@drive_letter}")
        @verbs = []
        @drive.Verbs.each do |verb|
            @verbs << verb.Name if verb.Name != ''
        end
    end

    def invoke_verb(verb_name)
        @drive.Verbs.each do |verb|
            verb.doIt if verb.Name== verb_name
        end
    end

    def eject
        self.invoke_verb("E&ject")
    end

    def open
        self.invoke_verb("&Open")
    end

    def explore
        self.invoke_verb("E&xplore")
    end

    def play
        self.invoke_verb("&Play")
    end

end

cd = CdRom.new('e:\\')
puts cd.verbs 