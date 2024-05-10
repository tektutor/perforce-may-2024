wget https://package.perforce.com/perforce.pubkey
gpg -n --import --import-options import-show perforce.pubkey
gpg -n --import --import-options import-show perforce.pubkey | grep -q "E58131C0AEA7B082C6DC4C937123CB760FF18869" && echo "true"
wget -qO - https://package.perforce.com/perforce.pubkey | apt-key add -
